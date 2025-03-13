plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.toVersion(libs.versions.java.sdk.get())
    targetCompatibility = JavaVersion.toVersion(libs.versions.java.sdk.get())
}

dependencies {
    testImplementation(libs.junit)
}
