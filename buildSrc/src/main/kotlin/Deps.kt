object Deps {

    const val TYPE_ARG = "String"
    const val M_KEY = "API_KEY"
    const val M_TOKEN = "API_TOKEN"
    const val RELEASE = "release"
    const val DEBUG = "debug"

    //Core Section
    const val androidxActivity = "androidx.activity:activity-compose:${Versions.androidxActivityVersion}"
    const val androidCoreX = "androidx.core:core-ktx:${Versions.androidCoreXVersion}"
    const val androidxLifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifeCycleVersion}"

    //Compose Section
    const val composeBOM = "androidx.compose:compose-bom:2023.03.00"
    const val composeGraphs = "androidx.compose.ui:ui-graphics"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"

    const val compoaseNavTest = "androidx.navigation:navigation-testing:${Versions.composeNavTestVersion}"
    const val composeNavigation =  "androidx.navigation:navigation-compose:${Versions.composeNavVersion}"
    const val composeAnimatioNavigation = "com.google.accompanist:accompanist-navigation-animation:${Versions.composeAnimationNavVersion}"


    // K O I N
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koinComposeVersion}"

    // I N T E R C E P T O R
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptorVersion}"

    //Material Section
    const val androidxMaterial3 = "androidx.compose.material3:material3"

    // R E T R O F I T
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    // S P L A S H   S C R E E N
    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreenVersion}"

    // Tests Section
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val junitTest = "androidx.test.ext:junit:${Versions.espressoVersion}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

}