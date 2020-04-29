import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version Versions.KOTLIN_VERSION
}

group = "dev.shtanko.ds"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin(Dependencies.Kotlin.STDLIB))
    testImplementation(TestDependencies.JUNIT)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}