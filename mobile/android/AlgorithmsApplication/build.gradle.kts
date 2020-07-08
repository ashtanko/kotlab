import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.detekt

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.10.0"
    id("com.diffplug.gradle.spotless") version "3.26.1"
}

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

val projectJvmTarget = JavaVersion.VERSION_1_8.toString()
val analysisDir = files(projectDir)
//val configFiles = files("$rootDir/config/detekt/detekt.yml")

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


    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        //dependsOn("spotlessKotlinApply") //todo uncomment
        sourceCompatibility = projectJvmTarget
        targetCompatibility = projectJvmTarget

        kotlinOptions {
            jvmTarget = projectJvmTarget
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }
    buildscript {

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
                //ktlint()
            }

        }
    }

    withPlugin("org.jetbrains.kotlin.android", spotlessConfiguration)
    withPlugin("org.jetbrains.kotlin.jvm", spotlessConfiguration)
}

detekt {
    input = files("app/src/main/java", "buildSrc/src/main/kotlin")
    parallel = false

    config = files("$rootDir/config/detekt/detekt.yml")
    buildUponDefaultConfig = false

    disableDefaultRuleSets = false

    debug = false

    ignoreFailures = true

    reports {
        xml {
            enabled = true
            destination = file("$buildDir/reports/detekt-report.xml")
        }
        html {
            enabled = true
            destination = file("$buildDir/reports/detekt-report.html")
        }
    }
}

tasks.withType<Detekt> {
    include("**/*.kt")
    include("**/*.kts")
    exclude(".*/resources/.*")
    exclude(".*/build/.*")
    exclude("/versions.gradle.kts")
    exclude("buildSrc/settings.gradle.kts")
}

tasks.withType<Test> {
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
}