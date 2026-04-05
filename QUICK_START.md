# Quick Start - Getting the App Running

## Prerequisites Check
Before starting, ensure you have:
1. Android Studio installed (latest version)
2. Android SDK with API 21+ installed
3. Java 8+ installed
4. An Android device (physical or emulator) with API 21+

## Steps to Run on Your Phone

### Step 1: Set Up Java (if not already done)
**Windows:**
```powershell
# Verify Java is installed
java -version

# If not found, add Java to PATH in Environment Variables
# JAVA_HOME = C:\Program Files\Java\jdk[version]
```

**macOS/Linux:**
```bash
java -version
```

### Step 2: Build the App
```bash
cd c:\Project\Git\CaptureIt
.\gradlew.bat assembleDebug
```

This creates `app/build/outputs/apk/debug/app-debug.apk`

### Step 3: Install on Device
**Using ADB** (Android Debug Bridge):
```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

**Using Android Studio**:
1. Connect phone via USB
2. Open project in Android Studio
3. Click Run → Select your device

### Step 4: Run the App
The app will be installed as "Wildlife Spotter". Open it from your phone's app drawer.

## First Time Setup
1. **Camera Permission**: Tap "Grant Permission" when prompted
2. **Take a Photo**: Tap the 📷 button at the bottom
3. **View Results**: See the identified species and points earned

## Verification
To verify the app is working:
- ✅ Camera preview shows live feed
- ✅ Tap capture button → Photo is taken
- ✅ Result shows "Identified: [Species]"
- ✅ No crashes when taking multiple photos

## Troubleshooting

### "JAVA_HOME not set"
```powershell
# Find Java installation
Get-Command java | Select-Object Source
# Result shows path, use that for JAVA_HOME
$env:JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_xxx"
.\gradlew.bat assembleDebug
```

### "Device not found"
```bash
adb devices  # List connected devices
# If no devices, enable USB debugging on phone
```

### Build Fails
```bash
.\gradlew.bat cleanBuildCache
.\gradlew.bat assembleDebug --stacktrace
```

### App Crashes on Launch
- Check Logcat in Android Studio for error messages
- Ensure device Android version is API 21+
- Try reinstalling: `adb uninstall com.wildlifespotter`

## What Works Now

✅ **Full Camera Integration**
- Real-time camera preview
- Photo capture and saving
- Permission handling

✅ **Species Identification**
- ML Kit image labeling
- Automatic species detection
- Rarity determination

✅ **Points System**
- Rarity-based points
- Photo quality scoring
- Wild/domestic detection

✅ **Data Persistence**
- Room database
- Sighting history
- User data storage

## Next Steps (After Basic Testing)

Once you confirm the camera works, you can add:
1. Advanced AR features
2. Leaderboard functionality
3. Photo quality analysis
4. User profile system
5. More sophisticated ML models

## Commands Reference

```bash
# Build
./gradlew assembleDebug

# Clean build
./gradlew clean

# Run tests
./gradlew test

# Install and run
./gradlew installDebug
adb shell am start -n com.wildlifespotter/.ui.MainActivity

# View logs
adb logcat

# Clear app data
adb shell pm clear com.wildlifespotter
```

## Success Indicators

You'll know it's working when you see:
1. App launches with "Wildlife Spotter" title
2. Camera preview shows your surroundings
3. Capture button (📷) is responsive
4. Photo results display identified animals
5. No crashes in Logcat
