plugins {
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    id("movie.android.library")
}

android {
    namespace = "com.development.movie"

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.moshi)
    implementation(libs.squareup.moshi.kotlin)
    ksp(libs.moshi.kotlin.codegen)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.moshi.kotlin)
    implementation(libs.retrofit2.converter.moshi)
    implementation("io.insert-koin:koin-androidx-compose:3.5.6")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation(project(":network"))
    implementation(project(":coredesign"))

    implementation(libs.retrofit)
    implementation(libs.converter.moshi)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}