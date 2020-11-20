import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType
import com.diffplug.gradle.spotless.SpotlessPlugin

plugins {
    // Kotlin support
    kotlin("jvm")
    java
    jacoco
    idea
    // ktlint linter - read more: https://github.com/JLLeitschuh/ktlint-gradle
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
    // detekt linter - read more: https://detekt.github.io/detekt/gradle.html
    id("io.gitlab.arturbosch.detekt") version Versions.DETEKT
    id("org.jetbrains.dokka") version "1.4.10"
    id("com.diffplug.gradle.spotless") version "3.26.1"
    id("com.autonomousapps.dependency-analysis") version "0.58.0"
}

buildscript {
    repositories {
        mavenCentral()
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}")
    }
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA}")
    implementation("org.jetbrains.kotlinx:lincheck:${Versions.LINCHECK}")

    testImplementation("org.jetbrains.kotlinx:lincheck:${Versions.LINCHECK}")
    testApi("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    // testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.assertj:assertj-core:3.16.1")
    testImplementation("org.mockito:mockito-core:3.3.3")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("ch.qos.logback:logback-core:1.2.3")
    testImplementation("ch.qos.logback:logback-classic:1.2.3")
    testImplementation("io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA}")
    testImplementation("com.carrotsearch:junit-benchmarks:0.7.0")

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

val projectJvmTarget = "1.8"
val analysisDir = files(projectDir)

val kotlinFiles = "**/*.kt"
val kotlinScriptFiles = "**/*.kts"
val resourceFiles = "**/resources/**"
val buildFiles = "**/build/**"
val depsFiles = "**/*Deps.kt"

subprojects {
    apply<org.jlleitschuh.gradle.ktlint.KtlintPlugin>()
    apply<SpotlessPlugin>()
    ktlint {
        this.debug.set(true)
    }

    detekt {
        config.from(file("config/detekt/detekt.yml"))
        parallel = true
        autoCorrect = true
        input = files("src/main/kotlin")

        reports {
            html.enabled = true
            xml.enabled = true
            txt.enabled = true
        }
    }
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

tasks {
    test {
        testLogging {
            events("passed", "skipped", "failed")
        }
    }

    withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = projectJvmTarget
            freeCompilerArgs = freeCompilerArgs + "-Xuse-experimental=kotlin.Experimental"
        }
    }

    withType<Test>().configureEach {
        testLogging.showStandardStreams = true
        useJUnitPlatform()
    }

    withType<Detekt>().configureEach {
        jvmTarget = "1.8"
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
