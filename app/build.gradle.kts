plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.ramiro.krogerbenchlc"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ramiro.krogerbenchlc"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //HILT

    implementation("com.google.dagger:hilt-android:2.51.1")

    kapt("com.google.dagger:hilt-android-compiler:2.51.1")

    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

//GSON

    implementation ("com.google.code.gson:gson:2.12.1")

//RETROFIT

    implementation ("com.squareup.retrofit2:retrofit:2.11.0")

    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

//OKHTTP

    implementation("com.squareup.okhttp3:okhttp:4.12.0")

// define a BOM and its version

    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))

// define any required OkHttp artifacts without version

    implementation("com.squareup.okhttp3:okhttp")

    implementation("com.squareup.okhttp3:logging-interceptor")

// ViewModel

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")

// ViewModel utilities for Compose

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

//COIL

    implementation("io.coil-kt.coil3:coil-compose:3.1.0")

    implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")

    testImplementation ("io.mockk:mockk-android:1.13.16")

    testImplementation ("io.mockk:mockk-agent:1.13.16")

//serialization

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

//navigation

    implementation("androidx.navigation:navigation-compose:2.8.8")

// Testing

    testImplementation ("androidx.arch.core:core-testing:2.2.0")

    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    testImplementation ("app.cash.turbine:turbine:1.0.0")
}