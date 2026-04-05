package com.wildlifespotter.location;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/wildlifespotter/location/LocationProvider;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentLocation", "Landroid/location/Location;", "locationListener", "Landroid/location/LocationListener;", "locationManager", "Landroid/location/LocationManager;", "getCurrentLocation", "startLocationUpdates", "", "listener", "stopLocationUpdates", "app_debug"})
public final class LocationProvider {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private android.location.LocationManager locationManager;
    @org.jetbrains.annotations.Nullable()
    private android.location.Location currentLocation;
    @org.jetbrains.annotations.NotNull()
    private final android.location.LocationListener locationListener = null;
    
    public LocationProvider(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void startLocationUpdates(@org.jetbrains.annotations.NotNull()
    android.location.LocationListener listener) {
    }
    
    public final void stopLocationUpdates(@org.jetbrains.annotations.NotNull()
    android.location.LocationListener listener) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.location.Location getCurrentLocation() {
        return null;
    }
}