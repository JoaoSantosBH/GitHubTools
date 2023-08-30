plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.carrefour.desafio.android.githubtools"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.carrefour.desafio.android.githubtools"
        minSdk = 24
        targetSdk = 33
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //Core Section
    implementation(Deps.androidxActivity)
    implementation(Deps.androidCoreX)
    implementation(Deps.androidxLifeCycle)

    //Compose Section
    implementation(Deps.androidxMaterial3)

    implementation(platform(Deps.composeBOM))
    implementation(Deps.composeGraphs)
    implementation(Deps.composeUiToolingPreview)
    implementation(Deps.composeUi)
    debugImplementation(Deps.composeUiTooling)
    debugImplementation(Deps.composeUiTest)

    //Unit Tests Section
    testImplementation(Deps.junit)

    //Instrumented Tests Section
    androidTestImplementation(platform(Deps.composeBOM))
    androidTestImplementation(Deps.composeUiTest)
    androidTestImplementation(Deps.espresso)
    androidTestImplementation(Deps.junitTest)


}