import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.detekt
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType
import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin

plugins {
    kotlin("jvm") version Versions.KOTLIN_VERSION
    id("java")
    id("idea")
    id("jacoco")
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
    id("org.jetbrains.dokka") version "0.10.1"
    id("com.diffplug.gradle.spotless") version "3.26.1"
}

buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.7")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testImplementation("org.assertj:assertj-core:3.16.1")
    testImplementation("org.mockito:mockito-core:3.3.1")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("ch.qos.logback:logback-core:1.2.3")
    testImplementation("ch.qos.logback:logback-classic:1.2.3")

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.10.0")
}

repositories {
    google()
    jcenter()
}

allprojects {
    repositories {
        mavenCentral()
        google()
        jcenter()
    }
}

val projectJvmTarget = JavaVersion.VERSION_1_8.toString()
val analysisDir = files(projectDir)

val kotlinFiles = "**/*.kt"
val kotlinScriptFiles = "**/*.kts"
val resourceFiles = "**/resources/**"
val buildFiles = "**/build/**"
val depsFiles = "**/*Deps.kt"

subprojects {
    pluginManager.apply(io.gitlab.arturbosch.detekt.DetektPlugin::class.java)

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
        jvmTarget = projectJvmTarget
    }

    pluginManager.configureSpotlessIntegration(subProject = project)

    tasks.withType<KotlinCompile> {
        dependsOn("spotlessKotlinApply") // todo uncomment
        sourceCompatibility = projectJvmTarget
        targetCompatibility = projectJvmTarget

        kotlinOptions {
            jvmTarget = projectJvmTarget
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }

    apply(plugin = "com.diffplug.gradle.spotless")
}

fun PluginContainer.configureAppAndModules(subProject: Project) = apply {
    whenPluginAdded {
        when (this) {
            is com.android.build.gradle.AppPlugin -> {
                subProject.extensions
                    .getByType<com.android.build.gradle.AppExtension>()
                    .applyAppCommons()
            }
            is com.android.build.gradle.LibraryPlugin -> {
                subProject.extensions
                    .getByType<com.android.build.gradle.LibraryExtension>()
                    .applyLibraryCommons()
            }
        }
    }
}

fun com.android.build.gradle.AppExtension.applyAppCommons() = apply { applyBaseCommons() }
fun com.android.build.gradle.LibraryExtension.applyLibraryCommons() = apply {
    applyBaseCommons()
}

fun com.android.build.gradle.BaseExtension.applyBaseCommons() = apply {
    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

fun PluginManager.configureKaptCache(subProject: Project) = apply {
    withPlugin("kotlin-kapt") {
        subProject.extensions
            .getByType<org.jetbrains.kotlin.gradle.plugin.KaptExtension>()
            .apply { useBuildCache = true }
    }
}

fun PluginManager.configureSpotlessIntegration(subProject: Project) = apply {
    val spotlessConfiguration: (AppliedPlugin) -> Unit = {
        subProject.pluginManager.apply(SpotlessPlugin::class.java)
        subProject.configure<SpotlessExtension> {
            kotlin {
                target("src/**/*.kt")
                ktlint()
                trimTrailingWhitespace()
                indentWithSpaces()
                endWithNewline()
            }

            format("misc") {
                target("**/*.gradle", "**/*.md", "**/.gitignore")
                indentWithSpaces()
                trimTrailingWhitespace()
                endWithNewline()
            }

            kotlinGradle {
                // same as kotlin, but for .gradle.kts files (defaults to '*.gradle.kts')
                target("*.gradle.kts", "additionalScripts/*.gradle.kts")
                // ktlint()
            }
        }
    }

    withPlugin("org.jetbrains.kotlin.android", spotlessConfiguration)
    withPlugin("org.jetbrains.kotlin.jvm", spotlessConfiguration)
}

// Configuration documentation: https://github.com/JLLeitschuh/ktlint-gradle#configuration
configure<KtlintExtension> {
    // Prints the name of failed rules.
    verbose.set(true)
    reporters {
        // Default "plain" reporter is actually harder to read.
        reporter(ReporterType.JSON)
    }

    disabledRules.set(
        setOf(
            // IntelliJ refuses to sort imports correctly.
            // This is a known issue: https://github.com/pinterest/ktlint/issues/527
            "import-ordering"
        )
    )
}

detekt {
    config.from(file("config/detekt/detekt.yml"))
    parallel = true
    autoCorrect = true

    reports {
        html.enabled = false
        xml.enabled = false
        txt.enabled = false
    }
}

tasks {
    test {
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    register<DokkaTask>("dokkaJavadoc") {
        outputFormat = "javadoc"
        outputDirectory = "$buildDir/javadoc"
    }

    register<Jar>("javadocJar") {
        archiveClassifier.set("javadoc")
        dependsOn("dokkaJavadoc")
        from("$buildDir/javadoc")
    }

    withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.Experimental"
        }
    }

    withType<Test>().configureEach {
        testLogging.showStandardStreams = true
        useJUnitPlatform()
    }

    withType<Detekt>().configureEach {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    withType<Detekt> {
        include("**/*.kt")
        include("**/*.kts")
        exclude(".*/resources/.*")
        exclude(".*/build/.*")
        exclude("/versions.gradle.kts")
        exclude("buildSrc/settings.gradle.kts")
    }

    withType<Test> {
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }

    // config JVM target to 1.8 for kotlin compilation tasks
    withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }
}
