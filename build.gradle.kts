import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.withType<Wrapper> {
    gradleVersion = "5.2.1"
}

plugins {
    kotlin("jvm") version "1.3.50"
}

group = "dev.shtanko.algorithms"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}