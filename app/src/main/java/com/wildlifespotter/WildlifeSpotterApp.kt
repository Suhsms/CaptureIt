package com.wildlifespotter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WildlifeSpotterApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize any necessary components here
    }
}