import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.suzhe.news"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.suzhe.news"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = false
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.0") //AndroidX Core 库
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2") //Android 生命周期相关的 Kotlin 扩展
    implementation("androidx.activity:activity-ktx:1.9.0") //Android Activity 的 Kotlin 扩展
    implementation("androidx.appcompat:appcompat:1.4.1") // AppCompat 库: 对新版本 Android 特性的向后兼容支持
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //UI框架，主要是用他的工具类，也可以单独拷贝出来
    //https://qmuiteam.com/android/get-started
    implementation ("com.qmuiteam:qmui:2.1.0")

    //权限框架
    //https://github.com/guolindev/PermissionX
    implementation ("com.guolindev.permissionx:permissionx:1.7.1")
}