/*
 * Copyright 2022 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import java.util.Locale

val projectJvmTarget = "11"
val satisfyingNumberOfCores = Runtime.getRuntime().availableProcessors().div(2).takeIf { it > 0 } ?: 1
val ktLintConfig: Configuration by configurations.creating
val isK2Enabled = false // kapt currently doesn't support new kotlin compiler
val k2CompilerArg = if (isK2Enabled) listOf("-Xuse-k2") else emptyList()

fun isLinux(): Boolean {
    val osName = System.getProperty("os.name").toLowerCase(Locale.ROOT)
    return listOf("linux", "mac os", "macos").contains(osName)
}

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    application
    jacoco
    idea
    alias(libs.plugins.kt.jvm)
    alias(libs.plugins.detekt)
    alias(libs.plugins.dokka)
    alias(libs.plugins.spotless)
    alias(libs.plugins.dependency.analysis)
    alias(libs.plugins.pitest)
    alias(libs.plugins.serialization)
    alias(libs.plugins.protobuf)
    kotlin("kapt") version "1.8.10"
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.kotlin.link") }
    gradlePluginPortal()
    maven("https://plugins.gradle.org/m2/")
}

application {
    mainClass.set("link.kotlin.scripts.Application")
}

val outputDir = "${project.buildDir}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))

val ktlintCheck by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Check Kotlin code style."
    classpath = ktLintConfig
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("src/**/*.kt")
}

val ktlintFormat by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Fix Kotlin code style deviations."
    classpath = ktLintConfig
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("-F", "src/**/*.kt")
}

plugins.withId("info.solidsoft.pitest") {
    configure<info.solidsoft.gradle.pitest.PitestPluginExtension> {
        jvmArgs.set(listOf("-Xmx1024m"))
        avoidCallsTo.set(setOf("kotlin.jvm.internal", "kotlin.Result"))
        targetClasses.set(setOf("dev.shtanko.*"))
        targetTests.set(setOf("dev.shtanko.*"))
        pitestVersion.set("1.9.0")
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
                    "exclude" to listOf("**/build/**", "**/spotless/*.kt"),
                ),
            ),
        )
        trimTrailingWhitespace()
        indentWithSpaces()
        endWithNewline()
        val delimiter = "^(package|object|import|interface|internal|@file|//startfile)"
        val licenseHeaderFile = rootProject.file("spotless/copyright.kt")
        licenseHeaderFile(licenseHeaderFile, delimiter)
    }
}

subprojects {
    apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
}

tasks {
    register<Copy>("copyGitHooks") {
        description = "Copies the git hooks from scripts/git-hooks to the .git folder."
        group = "git hooks"
        from("$rootDir/scripts/git-hooks/") {
            include("**/*.sh")
            rename("(.*).sh", "$1")
        }
        into("$rootDir/.git/hooks")
    }

    register<Exec>("installGitHooks") {
        description = "Installs the pre-commit git hooks from scripts/git-hooks."
        group = "git hooks"
        workingDir(rootDir)
        commandLine("chmod")
        args("-R", "+x", ".git/hooks/")
        dependsOn(named("copyGitHooks"))
        onlyIf {
            isLinux()
        }
        doLast {
            logger.info("Git hooks installed successfully.")
        }
    }

    register<Delete>("deleteGitHooks") {
        description = "Delete the pre-commit git hooks."
        group = "git hooks"
        delete(fileTree(".git/hooks/"))
    }

    afterEvaluate {
        tasks["clean"].dependsOn(tasks.named("installGitHooks"))
    }

    jacocoTestReport {
        reports {
            html.required.set(true)
            xml.required.set(true)
            xml.outputLocation.set(file("$buildDir/reports/jacoco/report.xml"))
        }
        executionData(file("build/jacoco/test.exec"))
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = projectJvmTarget
            freeCompilerArgs = freeCompilerArgs + k2CompilerArg
        }
    }

    withType<io.gitlab.arturbosch.detekt.Detekt> {
        description = "Runs over whole code base without the starting overhead for each module."
        parallel = true
        baseline.set(file("$rootDir/config/detekt/detekt-baseline.xml"))
        config.from(file("config/detekt/detekt.yml"))
        jvmTarget = projectJvmTarget

        setSource(files("src/main/kotlin", "src/test/kotlin"))
        include("**/*.kt")
        include("**/*.kts")
        exclude(".*/resources/.*")
        exclude(".*/build/.*")
        exclude("/versions.gradle.kts")

        reports {
            xml.required.set(true)
            html.required.set(true)
            txt.required.set(true)
            md.required.set(true)
        }
    }

    withType<DetektCreateBaselineTask> {
        jvmTarget = projectJvmTarget
    }

    withType<Test>().configureEach {
        jvmArgs = listOf(
            "-Dkotlintest.tags.exclude=Integration,EndToEnd,Performance",
        )
        testLogging {
            events("passed", "skipped", "failed")
        }
        testLogging.showStandardStreams = true
        useJUnitPlatform()
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = projectJvmTarget
        }
    }
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }

    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                val kotlin by registering {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.coroutines)
    implementation(libs.kotlin.coroutines.slf4j)
    implementation(libs.kotlin.coroutines.debug)
    implementation(libs.slf4j)
    implementation(libs.rxjava)
    implementation(libs.rxkotlin)
    implementation(libs.lincheck)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.retrofit.mock)
    implementation(libs.retrofit.converter)
    implementation(libs.okhttp)
    implementation(libs.dagger)
    implementation(libs.autovalue.annotations)
    implementation(libs.jmh)

    implementation("com.google.protobuf:protobuf-java:3.19.1")
    implementation("com.google.protobuf:protobuf-kotlin-lite:3.19.6")
    implementation("io.grpc:grpc-stub:1.15.1")
    implementation("io.grpc:grpc-protobuf:1.15.1")

    ktLintConfig(libs.ktlint)

    kapt(libs.dagger.compiler)
    kapt(libs.autovalue)
    kapt(libs.jmh.annprocess)

    testImplementation(libs.mockk)
    testImplementation(libs.junit)
    testImplementation(libs.jmh.annprocess)
    testImplementation(libs.jmh.benchmarks)
    testImplementation(libs.lincheck)
    testApi(libs.kotlin.coroutines.core)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.kotlintest.core)
    testImplementation(libs.kotlintest.junit5)
    testImplementation(libs.assertj)
    testImplementation(libs.hamcrest)
    testImplementation(libs.mockk)
    testImplementation(libs.mockito)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.logback)
    testImplementation(libs.logback.classic)
    testImplementation(libs.rxjava)
    testImplementation(libs.junit.benchmarks)
    testImplementation(libs.kotlin.serialization.json)
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("com.squareup.okhttp3:mockwebserver:5.0.0-alpha.11")
}
