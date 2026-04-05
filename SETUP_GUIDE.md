# Wildlife Spotter - Basic Setup Guide

## Overview
This is a basic runnable Android app that uses the camera to capture photos and identifies species using ML Kit's image labeling. The app implements a point system based on species rarity and photo quality.

## Project Structure
```
CaptureIt/
├── app/
│   ├── src/main/
│   │   ├── java/com/wildlifespotter/
│   │   │   ├── ui/                          # Compose UI components
│   │   │   │   ├── MainActivity.kt          # Main entry point
│   │   │   │   ├── camera/                  # Camera functionality
│   │   │   │   │   ├── CameraScreen.kt      # Camera UI with CameraX
│   │   │   │   │   └── CameraViewModel.kt   # Camera state management
│   │   │   │   └── theme/                   # Theme and typography
│   │   │   ├── ml/
│   │   │   │   └── SpeciesClassifier.kt     # ML Kit integration for species identification
│   │   │   ├── domain/
│   │   │   │   ├── model/                   # Data models
│   │   │   │   └── usecase/                 # Business logic
│   │   │   ├── data/
│   │   │   │   ├── local/                   # Room database
│   │   │   │   └── repository/              # Data access layer
│   │   │   └── di/                          # Dependency injection (Hilt)
│   │   └── res/
│   └── build.gradle.kts                     # Dependencies configuration
```

## Key Technologies
- **UI**: Jetpack Compose with Material 3
- **Camera**: CameraX library for camera integration
- **ML**: Google ML Kit for image labeling and species identification
- **Database**: Room for local data persistence
- **DI**: Hilt for dependency injection
- **Architecture**: MVVM with Repository pattern

## Features Implemented
1. ✅ Camera screen with real-time camera preview
2. ✅ Photo capture functionality
3. ✅ Species identification using ML Kit
4. ✅ Points calculation based on:
   - Species rarity (common, uncommon, rare, very rare)
   - Photo quality (0.5-1.0 scale)
   - Wild vs domestic bonus
5. ✅ Local database storage for sightings
6. ✅ Permission handling for camera and location

## Setup Instructions

### Prerequisites
- Android Studio (latest version)
- Java 8+ (JDK)
- Android SDK (API level 21+)
- Gradle 7.0+

### Environment Setup
1. **Set JAVA_HOME**:
   - Windows:
     ```powershell
     $env:JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_xxx"
     ```
   - macOS/Linux:
     ```bash
     export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_xxx.jdk/Contents/Home
     ```

2. **Set up Android SDK**:
   - Download Android SDK Command-line Tools
   - Set `ANDROID_HOME` and add to PATH

### Building the Project

1. **Clone and navigate to project**:
   ```bash
   cd CaptureIt
   ```

2. **Build the APK**:
   ```bash
   ./gradlew assembleDebug
   ```

3. **Run on emulator or device**:
   ```bash
   ./gradlew installDebug
   adb shell am start -n com.wildlifespotter/.ui.MainActivity
   ```

## Running on Mobile Device

### Option 1: Using Android Studio
1. Open the project in Android Studio
2. Connect an Android device (API level 21+) via USB
3. Click "Run" → Select your device
4. Grant camera permission when prompted

### Option 2: Using ADB
```bash
# Build and install
./gradlew installDebug

# Launch
adb shell am start -n com.wildlifespotter/.ui.MainActivity
```

## App Usage

1. **Grant Permissions**: When first launched, the app requests camera permission
2. **Camera Screen**: Use the camera preview to frame your subject
3. **Capture Photo**: Tap the circular capture button at the bottom
4. **Automatic Identification**: The app automatically identifies the species
5. **View Results**: Results are displayed with points earned

## Point System

### Rarity Points
- Common: 1 point
- Uncommon: 3 points
- Rare: 5 points
- Very Rare: 10 points

### Photo Quality Points
- Quality ≥ 0.9: 5 points
- Quality ≥ 0.75: 3 points
- Quality ≥ 0.5: 1 point
- Quality < 0.5: 0 points

### Bonuses
- Wild species: +2 points bonus
- Domestic species: No bonus

## Project Features Overview

### Camera Integration (CameraScreen.kt)
- Uses CameraX for modern camera access
- Live camera preview
- Photo capture with file saving
- Permission handling with Accompanist

### ML Integration (SpeciesClassifier.kt)
- Uses Firebase ML Kit for image labeling
- Automatically determines species from image
- Estimates rarity based on species name patterns
- Identifies if species is wild or domestic

### Database (AppDatabase.kt)
- Room database with three main tables:
  - **species**: Stores wildlife species data
  - **sightings**: Stores user captured sightings
  - **users**: Stores user account data
- Automatic persistence of sightings

### Dependency Injection
- **Hilt** for automatic dependency management
- Modules:
  - `DatabaseModule`: Provides database and DAOs
  - `MLModule`: Provides ML classifier
  - `NetworkModule`: Provides Retrofit client
  - `AppModule`: General dependencies

## Future Enhancements

1. **Advanced Point Systems**:
   - Family/genus bonuses for 5+ captures
   - Travel distance bonuses
   - Time-based multipliers
   - Trading/evolution system

2. **Features to Add**:
   - Leaderboard screen
   - Collection gallery
   - Map view of sightings
   - User profiles and statistics
   - Social sharing

3. **ML Improvements**:
   - Custom TensorFlow Lite model training
   - Photo quality assessment
   - Multi-species detection
   - Confidence scoring

## Troubleshooting

#### Build Errors
- Clear gradle cache: `./gradlew cleanBuildCache`
- Sync project: In Android Studio, Gradle → Sync Now

#### Camera Permission Issues
- Ensure Android 6.0+ for runtime permissions
- Check AndroidManifest.xml has required permissions

#### ML Kit Errors
- Ensure Google Play Services is available on device
- Check if Google ML Kit is properly initialized

#### Database Issues
- Clear app data: `adb shell pm clear com.wildlifespotter`
- Reset database in next build

## Testing

The project includes basic unit tests for use cases:
- `CalculatePointsUseCaseTest`: Tests point calculation logic
- `IdentifySpeciesUseCaseTest`: Tests species identification
- `EvaluateRarityUseCaseTest`: Tests rarity evaluation

Run tests with:
```bash
./gradlew test
```

## Development Tips

1. **Hot Reload**: Use Compose Preview in Android Studio for fast UI iteration
2. **Debugging**: Use Logcat to view app logs
3. **Database Inspection**: Use Android Device Monitor to browse Room database
4. **ML Testing**: Test with various animal photos to improve rarity detection

## License
This project is provided as-is for educational purposes.

## Support
For issues or questions, refer to the inline code documentation and comments throughout the codebase.
