import Deps.DEBUG
import Deps.M_TOKEN
import Deps.RELEASE
import Deps.TYPE_ARG

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.carrefour.desafio.android.githubtools"
    compileSdk = 33
buildFeatures.buildConfig = true
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

        val token = providers.gradleProperty(M_TOKEN).get()

        getByName(RELEASE) {
            isMinifyEnabled = false
            buildConfigField(TYPE_ARG, M_TOKEN, token)
        }

        getByName(DEBUG) {
            isMinifyEnabled = false
            buildConfigField(TYPE_ARG, M_TOKEN, token)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
        buildConfig = true
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
    implementation(Deps.composeNavigation)
    implementation(Deps.composeAnimatioNavigation)
    debugImplementation(Deps.composeUiTooling)
    debugImplementation(Deps.composeUiTest)

//        implementation"(Deps.coilCompose)

    //Koin
        implementation(Deps.koinCompose)

    //Interceptor

        implementation(Deps.interceptor)

    //Retrofit
    implementation(Deps.retrofit)
    implementation(Deps.retrofitGson)

    //Splash Screen
    implementation(Deps.splashScreen)

    //Unit Tests Section
    testImplementation(Deps.junit)

    //Instrumented Tests Section
    androidTestImplementation(platform(Deps.composeBOM))
    androidTestImplementation(Deps.composeUiTest)
    androidTestImplementation(Deps.espresso)
    androidTestImplementation(Deps.junitTest)


}