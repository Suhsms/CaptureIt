package com.wildlifespotter.ui.camera

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.wildlifespotter.ml.SpeciesClassifier
import kotlinx.coroutines.launch
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraScreen(
    viewModel: CameraViewModel = hiltViewModel()
) {
    val cameraPermissionState = rememberPermissionState(
        Manifest.permission.CAMERA
    )
    
    val context = LocalContext.current
    
    LaunchedEffect(Unit) {
        if (cameraPermissionState.status != PermissionStatus.Granted) {
            cameraPermissionState.launchPermissionRequest()
        }
    }

    when (cameraPermissionState.status) {
        PermissionStatus.Granted -> {
            CameraScreenContent(context, viewModel)
        }
        is PermissionStatus.Denied -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "Camera permission is required to use this feature",
                        color = Color.White
                    )
                    Button(
                        onClick = {
                            cameraPermissionState.launchPermissionRequest()
                        },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Grant Permission")
                    }
                }
            }
        }
    }
}

@Composable
private fun CameraScreenContent(
    context: Context,
    viewModel: CameraViewModel
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
    var isLoading by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        var previewView by remember { mutableStateOf<PreviewView?>(null) }
        
        AndroidView(
            factory = { ctx ->
                PreviewView(ctx).also { preview ->
                    previewView = preview
                    setupCamera(ctx, lifecycleOwner, preview) { imageCap ->
                        imageCapture = imageCap
                    }
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        // Top bar
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.3f))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Wildlife Spotter",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall
            )
        }

        // Capture button
        Button(
            onClick = {
                imageCapture?.let { capture ->
                    isLoading = true
                    captureAndAnalyze(context, capture) { speciesName ->
                        scope.launch {
                            viewModel.onSpeciesIdentified(speciesName)
                            result = "Identified: $speciesName"
                            isLoading = false
                        }
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
                .size(64.dp),
            shape = CircleShape
        ) {
            Text("📷", style = MaterialTheme.typography.headlineLarge)
        }

        // Loading indicator
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.White)
            }
        }

        // Result display
        result?.let { res ->
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 100.dp)
                    .background(Color.Green.copy(alpha = 0.8f), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(res, color = Color.White)
            }
        }
    }
}

private fun setupCamera(
    context: Context,
    lifecycleOwner: LifecycleOwner,
    previewView: PreviewView,
    onImageCaptureReady: (ImageCapture) -> Unit
) {
    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
    cameraProviderFuture.addListener({
        try {
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            
            // Create preview and connect it to PreviewView
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(previewView.surfaceProvider)
            
            val imageCaptureBuilder = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
            val imageCapture = imageCaptureBuilder.build()

            val cameraSelector = CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build()

            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, preview, imageCapture)
            onImageCaptureReady(imageCapture)
        } catch (exc: Exception) {
            exc.printStackTrace()
        }
    }, ContextCompat.getMainExecutor(context))
}

private fun captureAndAnalyze(
    context: Context,
    imageCapture: ImageCapture,
    onSpeciesIdentified: (String) -> Unit
) {
    val outputFile = File(context.cacheDir, "${SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.US).format(Date())}.jpg")
    outputFile.parentFile?.mkdirs()
    
    val outputOptions = ImageCapture.OutputFileOptions.Builder(outputFile).build()

    imageCapture.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                try {
                    // Simulate species detection - in real app, would use ML Kit
                    val speciesOptions = listOf(
                        "Eagle",
                        "Deer",
                        "Butterfly",
                        "Sparrow",
                        "Rabbit",
                        "Fox",
                        "Squirrel"
                    )
                    val detectedSpecies = speciesOptions.random()
                    onSpeciesIdentified(detectedSpecies)
                } catch (e: Exception) {
                    e.printStackTrace()
                    onSpeciesIdentified("Detection Failed")
                }
            }

            override fun onError(exception: ImageCaptureException) {
                exception.printStackTrace()
                onSpeciesIdentified("Capture Error")
            }
        }
    )
}

private fun rotateBitmap(bitmap: Bitmap, degrees: Float): Bitmap {
    val matrix = Matrix().apply { postRotate(degrees) }
    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
}