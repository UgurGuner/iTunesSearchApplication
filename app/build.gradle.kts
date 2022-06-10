plugins {
    id("com.android.application")
    kotlin("android")
}

android {

    setCompileSdkVersion(32)

    defaultConfig {
        applicationId = "com.eugurguner.iTunesSearchApp"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

}

val composeVersion: String by rootProject.extra

dependencies {
    implementation("androidx.core:core-ktx:1.8.0")

    implementation("androidx.compose.ui:ui:")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    implementation("androidx.paging:paging-compose:1.0.0-alpha15")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("com.squareup.moshi:moshi-kotlin:1.9.3")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.moshi:moshi:1.12.0")
    implementation("io.coil-kt:coil-compose:2.1.0")

    implementation("com.google.accompanist:accompanist-swiperefresh:0.23.1")

    implementation("io.insert-koin:koin-core:3.2.0")
    implementation("io.insert-koin:koin-androidx-compose:3.2.0")
    implementation("androidx.appcompat:appcompat:1.4.2")

    implementation("com.airbnb.android:lottie-compose:5.2.0")

    implementation("me.vponomarenko:compose-shimmer:1.0.0")

    implementation("androidx.navigation:navigation-compose:2.5.0-rc01")

    implementation("androidx.core:core-splashscreen:1.0.0-rc01")

}