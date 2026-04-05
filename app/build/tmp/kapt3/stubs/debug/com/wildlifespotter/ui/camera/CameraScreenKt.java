package com.wildlifespotter.ui.camera;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0003\u001a,\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0002\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a4\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000bH\u0002\u00a8\u0006\u0018"}, d2 = {"CameraScreen", "", "viewModel", "Lcom/wildlifespotter/ui/camera/CameraViewModel;", "CameraScreenContent", "context", "Landroid/content/Context;", "captureAndAnalyze", "imageCapture", "Landroidx/camera/core/ImageCapture;", "onSpeciesIdentified", "Lkotlin/Function1;", "", "rotateBitmap", "Landroid/graphics/Bitmap;", "bitmap", "degrees", "", "setupCamera", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "previewView", "Landroidx/camera/view/PreviewView;", "onImageCaptureReady", "app_debug"})
public final class CameraScreenKt {
    
    @kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
    @androidx.compose.runtime.Composable()
    public static final void CameraScreen(@org.jetbrains.annotations.NotNull()
    com.wildlifespotter.ui.camera.CameraViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CameraScreenContent(android.content.Context context, com.wildlifespotter.ui.camera.CameraViewModel viewModel) {
    }
    
    private static final void setupCamera(android.content.Context context, androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.camera.view.PreviewView previewView, kotlin.jvm.functions.Function1<? super androidx.camera.core.ImageCapture, kotlin.Unit> onImageCaptureReady) {
    }
    
    private static final void captureAndAnalyze(android.content.Context context, androidx.camera.core.ImageCapture imageCapture, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSpeciesIdentified) {
    }
    
    private static final android.graphics.Bitmap rotateBitmap(android.graphics.Bitmap bitmap, float degrees) {
        return null;
    }
}