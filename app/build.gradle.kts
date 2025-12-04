plugins {
    id("com.android.application") version "8.1.0" apply false
    kotlin("android") version "1.8.21" apply false
}
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.forcephonemic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.forcephonemic"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "0.1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    // Shizuku client (optional) - user must add correct dependency as needed.
    implementation("rikka.shizuku:api:14.1.0")
}
