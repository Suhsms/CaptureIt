plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.wildlifespotter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.wildlifespotter"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/DEPENDENCIES"
            excludes += "/META-INF/NOTICE"
            excludes += "/META-INF/LICENSE"
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    
    // Compose
    implementation("androidx.compose.ui:ui:1.5.3")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.compose.material:material:1.5.3")
    implementation("androidx.compose.runtime:runtime:1.5.3")
    implementation("androidx.compose.foundation:foundation:1.5.3")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    
    // Camera (CameraX)
    implementation("androidx.camera:camera-core:1.3.0")
    implementation("androidx.camera:camera-camera2:1.3.0")
    implementation("androidx.camera:camera-lifecycle:1.3.0")
    implementation("androidx.camera:camera-extensions:1.3.0")
    implementation("androidx.camera:camera-view:1.3.0")
    
    // ML Kit
    implementation("com.google.mlkit:vision-common:17.3.0")
    
    // Permissions (Accompanist)
    implementation("com.google.accompanist:accompanist-permissions:0.32.0")
    
    // Room Database
    implementation("androidx.room:room-ktx:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")
    
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    
    // Hilt DI
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    
    // Location Services
    implementation("com.google.android.gms:play-services-location:21.0.1")
    
    // TensorFlow Lite (optional, but already in your setup)
    implementation("org.tensorflow:tensorflow-lite:2.10.0")
    implementation("org.tensorflow:tensorflow-lite-gpu:2.10.0")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}