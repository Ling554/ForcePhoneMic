# ForcePhoneMic - Android project skeleton

This repository contains a minimal Android Studio project skeleton (Kotlin) which demonstrates the concept
of trying to force audio input routing to the phone's built-in microphone while a headset is plugged in.

IMPORTANT NOTES:
1. **This project is a proof-of-concept skeleton only**. It does NOT guarantee success on any device.
2. Many audio routing APIs are restricted or deprecated. Forcing input device often requires either:
   - Root access, or
   - Shizuku with proper permission grant, or
   - Modifying platform audio policy (vendor-specific).
3. Building an APK from this project must be done on your machine (Android Studio or command line).
4. Use responsibly. Some devices may not allow these hacks. You may need to adapt code for your target device.

## How to build (locally)

1. Install Android Studio (Arctic Fox or newer recommended).
2. Open this project folder.
3. Let Gradle sync and install required SDK (compileSdk 34).
4. Build a debug APK via 'Build > Build Bundle(s) / APK(s) > Build APK(s)'.
   Or use command line:
     ./gradlew assembleDebug

## Shizuku usage (optional)
- Install Shizuku on your device and grant necessary permissions.
- The current Shizuku usage in this skeleton is minimal and for demonstration only.
- Consult Shizuku docs for integrating properly.

## Disclaimer
- I could not compile an APK here. I packaged the project skeleton so you can build the APK on your machine/device.
- If you want, I can provide a GitHub Actions workflow you can paste into your repo to auto-build an APK on push.
- 
