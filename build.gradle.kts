import com.diffplug.gradle.spotless.SpotlessPlugin
import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

val projectJvmTarget = "1.8"
val satisfyingNumberOfCores = Runtime.getRuntime().availableProcessors().div(2).takeIf { it > 0 } ?: 1

plugins {
    kotlin("jvm")
    java
    jacoco
    idea
    // ktlint linter - read more: https://github.com/JLLeitschuh/ktlint-gradle
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
    // detekt linter - read more: https://detekt.github.io/detekt/gradle.html
    id("io.gitlab.arturbosch.detekt") version Versions.DETEKT
    id("org.jetbrains.dokka") version "1.4.20"
    id("com.diffplug.gradle.spotless") version "3.26.1"
    id("com.autonomousapps.dependency-analysis") version "0.58.0"
    id("info.solidsoft.pitest") version "1.5.1"
    kotlin("plugin.serialization") version "1.4.21"
}

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN_VERSION}")
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:${Versions.COROUTINES}")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA}")
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation("org.jetbrains.kotlinx:lincheck:${Versions.LINCHECK}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")

    testImplementation("org.jetbrains.kotlinx:lincheck:${Versions.LINCHECK}")
    testApi("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.assertj:assertj-core:3.18.1")
    testImplementation("org.mockito:mockito-core:3.6.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("ch.qos.logback:logback-core:1.2.3")
    testImplementation("ch.qos.logback:logback-classic:1.2.3")
    testImplementation("io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA}")
    testImplementation("com.carrotsearch:junit-benchmarks:0.7.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("io.mockk:mockk:1.10.0")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:${Versions.SPEK}") {
        exclude(group = "org.jetbrains.kotlin")
    }
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:${Versions.SPEK}") {
        exclude(group = "org.jetbrains.kotlin")
    }
    // spek requires kotlin-reflect, can be omitted if already in the classpath
    testRuntimeOnly(kotlin("reflect"))

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.DETEKT}")
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

// Configuration documentation: https://github.com/JLLeitschuh/ktlint-gradle#configuration
configure<KtlintExtension> {
    // Prints the name of failed rules.
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    outputColorName.set("RED")
    ignoreFailures.set(true)
    enableExperimentalRules.set(false)
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
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

plugins.withId("info.solidsoft.pitest") {
    configure<info.solidsoft.gradle.pitest.PitestPluginExtension> {
        jvmArgs.set(listOf("-Xmx1024m"))
        avoidCallsTo.set(setOf("kotlin.jvm.internal", "kotlin.Result"))
        targetClasses.set(setOf("dev.shtanko.algorithms.*"))
        targetTests.set(setOf("dev.shtanko.algorithms.*"))
        pitestVersion.set("1.4.11")
        verbose.set(true)
        threads.set(System.getenv("PITEST_THREADS")?.toInt() ?: satisfyingNumberOfCores)
        outputFormats.set(setOf("XML", "HTML"))
        testPlugin.set("junit5")
        junit5PluginVersion.set("0.12")
    }
}

spotless {
    kotlin {
        target(
            fileTree(
                mapOf(
                    "dir" to ".",
                    "include" to listOf("**/*.kt"),
                    "exclude" to listOf("**/build/**", "**/spotless/*.kt")
                )
            )
        )
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
        licenseHeaderFile(
            rootProject.file("spotless/copyright.kt"),
            "^(package|object|import|interface|internal|@file|//startfile)"
        )
    }
}

subprojects {
    apply<KtlintPlugin>()
    apply<SpotlessPlugin>()
}

tasks {
    jacocoTestReport {
        reports {
            html.isEnabled = true
            xml.isEnabled = true
            xml.destination = file("$buildDir/reports/jacoco/report.xml")
            csv.isEnabled = false
        }
        executionData(file("build/jacoco/test.exec"))
    }

    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = projectJvmTarget
            freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.Experimental"
        }
    }

    withType<Test>().configureEach {
        useJUnitPlatform {
            includeEngines("spek2", "junit-jupiter")
        }
        testLogging {
            events("passed", "skipped", "failed")
        }
        testLogging.showStandardStreams = true
        useJUnitPlatform()
    }

    withType<Detekt>().configureEach {
        jvmTarget = projectJvmTarget
    }

    withType<Detekt> {
        description = "Runs over whole code base without the starting overhead for each module."
        parallel = true
        baseline.set(file("$rootDir/config/detekt/detekt-baseline.xml"))
        config.from(file("config/detekt/detekt.yml"))

        include("**/*.kt")
        include("**/*.kts")
        exclude(".*/resources/.*")
        exclude(".*/build/.*")
        exclude("/versions.gradle.kts")
        exclude("buildSrc/settings.gradle.kts")

        reports {
            xml.enabled = true
            xml.destination = file("build/reports/detekt/detekt.xml")
            html.enabled = true
            txt.enabled = true
        }
    }

    withType<Test> {
        maxParallelForks = satisfyingNumberOfCores
    }

    // config JVM target to 1.8 for kotlin compilation tasks
    withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = projectJvmTarget
    }
}
