plugins {
    id("com.android.application")

}

android {
    namespace = "edu.utsa.cs3443.a3dseek"
    compileSdk = 34

    buildFeatures {
        buildConfig = true  // Enable BuildConfig feature
    }

    defaultConfig {
        applicationId = "edu.utsa.cs3443.a3dseek"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            buildConfigField("String", "THINGIVERSE_CLIENT_ID", "\"${project.findProperty("THINGIVERSE_CLIENT_ID") ?: ""}\"")
            buildConfigField("String", "THINGIVERSE_CLIENT_SECRET", "\"${project.findProperty("THINGIVERSE_CLIENT_SECRET") ?: ""}\"")
            buildConfigField("String", "THINGIVERSE_APP_TOKEN", "\"${project.findProperty("THINGIVERSE_APP_TOKEN") ?: ""}\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "THINGIVERSE_CLIENT_ID", "\"${project.findProperty("THINGIVERSE_CLIENT_ID") ?: ""}\"")
            buildConfigField("String", "THINGIVERSE_CLIENT_SECRET", "\"${project.findProperty("THINGIVERSE_CLIENT_SECRET") ?: ""}\"")
            buildConfigField("String", "THINGIVERSE_APP_TOKEN", "\"${project.findProperty("THINGIVERSE_APP_TOKEN") ?: ""}\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Retrofit for networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // GSON converter for parsing JSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Optional: Logging Interceptor (for debugging network calls)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Glide annotation processor
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
