plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.movies"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.movies"
        minSdk = 24
        targetSdk = 34
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("androidx.tracing:tracing:1.2.0")

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")

    annotationProcessor ("androidx.room:room-compiler:2.6.1")


    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.5")

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
}