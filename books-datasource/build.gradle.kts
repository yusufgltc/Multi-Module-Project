import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.example.books_datasource"
}

dependencies {
    room()
    retrofit()
    hilt()
    test()
}