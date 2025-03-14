buildscript {
    dependencies {
        classpath(libs.plugin.android)
        classpath(libs.plugin.dagger.hilt)
        classpath(libs.plugin.google.firebase.appDistribution)
        classpath(libs.plugin.google.firebase.crashlytics)
        classpath(libs.plugin.google.ksp)
        classpath(libs.plugin.google.services)
        classpath(libs.plugin.kotlin)
        classpath(libs.plugin.kotlin.serialization)
        classpath(libs.plugin.kotlinter)
        classpath(libs.plugin.playPublisher)
        classpath(libs.plugin.square.sqldelight)
    }
}

plugins {
    alias(libs.plugins.dependencyUpdates)
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.compose.compiler) apply false
}

tasks.dependencyUpdates {
    outputFormatter = "html"
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean =
    listOf("alpha", "beta", "rc", "eap").any { version.contains(it, true) }
