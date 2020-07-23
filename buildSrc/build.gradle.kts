import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

version = "1.0-SNAPSHOT"

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.fabric.io/public")
    maven("https://plugins.gradle.org/m2/")
    maven("https://ci.android.com/builds/submitted/5837096/androidx_snapshot/latest/repository")
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

object PluginsVersions {
    const val GRADLE_ANDROID = "4.0.1"
    const val GRADLE_VERSIONS = "0.27.0"
    const val KOTLIN = "1.3.72"
    const val NAVIGATION = "2.1.0"
    const val JACOCO = "0.16.0"
    const val FABRIC = "1.31.2"
    const val DOKKA = "0.10.0"
    const val KTLINT = "0.36.0"
    const val SPOTLESS = "3.26.1"
    const val DETEKT = "1.2.2"
    const val GRAPH_GENERATOR = "0.6.0-SNAPSHOT"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
