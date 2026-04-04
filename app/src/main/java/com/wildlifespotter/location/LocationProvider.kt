package com.wildlifespotter.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.core.app.ActivityCompat

class LocationProvider(private val context: Context) {

    private var locationManager: LocationManager? = null
    private var currentLocation: Location? = null

    init {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    fun startLocationUpdates(listener: LocationListener) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10f, listener)
    }

    fun stopLocationUpdates(listener: LocationListener) {
        locationManager?.removeUpdates(listener)
    }

    fun getCurrentLocation(): Location? {
        return currentLocation
    }

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            currentLocation = location
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

        override fun onProviderEnabled(provider: String) {}

        override fun onProviderDisabled(provider: String) {}
    }
}