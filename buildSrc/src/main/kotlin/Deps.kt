object Deps {

    //Core Section
    const val androidxActivity = "androidx.activity:activity-compose:${Versions.androidxActivityVersion}"
    const val androidCoreX = "androidx.core:core-ktx:${Versions.androidCoreXVersion}"
    const val androidxLifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifeCycleVersion}"

    //Compose Section
    const val composeBOM = "androidx.compose:compose-bom:2023.03.00"
    const val composeGraphs = "androidx.compose.ui:ui-graphics"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"

    //Material Section
    const val androidxMaterial3 = "androidx.compose.material3:material3"

    // Tests Section
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val junitTest = "androidx.test.ext:junit:${Versions.espressoVersion}"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

}