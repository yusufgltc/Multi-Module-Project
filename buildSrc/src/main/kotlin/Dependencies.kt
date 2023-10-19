import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeUiManifest = "androidx.compose.ui:ui-test-manifest"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val junit = "junit:junit:${Versions.junit}"
    const val junitAndroid = "androidx.test.ext:junit:${Versions.junitAndroid}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junitUi = "androidx.compose.ui:ui-test-junit4"
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    debugImplementation(Dependencies.composeUiToolingPreview)
    debugImplementation(Dependencies.composeUiManifest)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeActivity)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.booksDataSource() {
    implementation(project(":books-datasource"))
}

fun DependencyHandler.booksUi() {
    implementation(project(":books-ui"))
}

fun DependencyHandler.test() {
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitAndroid)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(Dependencies.junitUi)
}