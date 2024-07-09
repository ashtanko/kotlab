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

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0

val projectJvmTarget = 17
val satisfyingNumberOfCores = Runtime.getRuntime().availableProcessors().div(2).takeIf { it > 0 } ?: 1
val ktLintConfig: Configuration by configurations.creating
val isK2Enabled = true
val k2CompilerArg = if (isK2Enabled) listOf("-Xuse-k2") else emptyList()
val outputDir = "${project.layout.buildDirectory}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))
val kotlinVersion = KOTLIN_2_0

fun isLinux(): Boolean {
    val osName = System.getProperty("os.name").lowercase()
    return listOf("linux", "mac os", "macos").contains(osName)
}

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    application
    jacoco
    id("com.github.nbaztec.coveralls-jacoco") version "1.2.16"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    // id ("org.sonarqube") version "4.4.1.3373"
    idea
    alias(libs.plugins.kt.jvm)
    alias(libs.plugins.detekt)
    alias(libs.plugins.dokka)
    alias(libs.plugins.spotless)
    alias(libs.plugins.dependency.analysis)
    alias(libs.plugins.pitest)
    alias(libs.plugins.serialization)
    alias(libs.plugins.kover)
    alias(libs.plugins.diktat)
}

jacoco {
    toolVersion = "0.8.11"
}

//sonarqube {
//    properties {
//        setProperty("sonar.projectKey", "ashtanko_kotlab")
//        setProperty("sonar.organization", "ashtanko")
//        setProperty("sonar.host.url", "https://sonarcloud.io")
//    }
//}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.kotlin.link") }
    gradlePluginPortal()
    maven("https://plugins.gradle.org/m2/")
}

application {
    mainClass.set("link.kotlin.scripts.Application")
    mainClass.set("dev.shtanko.report.ReportParserKt")
}

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
        jvmArgs.set(listOf("-Xmx2048m"))
        avoidCallsTo.set(setOf("kotlin.jvm.internal", "kotlin.Result"))
        targetClasses.set(setOf("dev.shtanko.*"))
        targetTests.set(setOf("dev.shtanko.*"))
        pitestVersion.set("1.15.0")
        verbose.set(true)
        timestampedReports.set(false)
        threads.set(System.getenv("PITEST_THREADS")?.toInt() ?: satisfyingNumberOfCores)
        outputFormats.set(setOf("XML", "HTML"))
        testPlugin.set("junit5")
        junit5PluginVersion.set("1.0.0")
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

koverReport {
    verify {
        rule {
            minBound(80)
        }
    }
}

tasks {
    named("distZip") {
        dependsOn(withType<ShadowJar>())
    }

    withType<ShadowJar> {
        print("Build Report Parser: $name")
        archiveFileName.set("detekt_report_parser.jar")
        archiveVersion.set("")
        archiveClassifier.set("")
        manifest {
            attributes(
                "Main-Class" to "dev.shtanko.report.ReportParserKt",
                "Implementation-Version" to project.version,
            )
        }
    }

    withType<Test> {
        maxParallelForks = 1
        jvmArgs(
            "--add-opens", "java.base/jdk.internal.misc=ALL-UNNAMED",
            "--add-exports", "java.base/jdk.internal.util=ALL-UNNAMED",
            "--add-exports", "java.base/sun.security.action=ALL-UNNAMED"
        )
    }
    compileKotlin {
        compilerOptions {
            apiVersion.set(kotlinVersion)
            languageVersion.set(kotlinVersion)
        }
    }
    kotlin {
        jvmToolchain(projectJvmTarget)
    }
    jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    minimum = "0.5".toBigDecimal()
                }
            }
        }
    }

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
        dependsOn(test)
        reports {
            listOf(
                html, xml, csv,
            ).map { it.required }.forEach { it.set(true) }
        }
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "$projectJvmTarget"
            freeCompilerArgs = freeCompilerArgs + k2CompilerArg
        }
    }

    withType<io.gitlab.arturbosch.detekt.Detekt> {
        description = "Runs over whole code base without the starting overhead for each module."
        parallel = true
        baseline.set(file("$rootDir/config/detekt/detekt-baseline.xml"))
        config.from(file("config/detekt/detekt.yml"))
        jvmTarget = "$projectJvmTarget"

        setSource(files("src/main/kotlin", "src/test/kotlin"))
        setOf(
            "**/*.kt",
            "**/*.kts",
            ".*/resources/.*",
            ".*/build/.*",
            "/versions.gradle.kts",
        ).forEach {
            include(it)
        }

        reports {
            reports.apply {
                listOf(xml, html, txt, md).map { it.required }.forEach {
                    it.set(true)
                }
            }
        }
    }

    withType<DetektCreateBaselineTask> {
        jvmTarget = "$projectJvmTarget"
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
        finalizedBy(withType(JacocoReport::class.java))
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "$projectJvmTarget"
        }
    }
}

dependencies {
    libs.apply {
        kotlin.apply {
            implementation(stdlib)
            implementation(reflect)
            implementation(coroutines)
            implementation(coroutines.slf4j)
            implementation(coroutines.debug)
        }
        implementation(slf4j)
        implementation(rxjava)
        implementation(rxkotlin)
        implementation(lincheck)
        implementation(kotlin.serialization.json)
        implementation(retrofit)
        implementation(retrofit.mock)
        implementation(retrofit.converter)
        implementation(okhttp)
        implementation("org.openjdk.jol:jol-core:0.17")

        ktLintConfig(ktlint)
        implementation(jsoup)

        testImplementation(mockk)
        testImplementation(junit)
        testImplementation(lincheck)
        testApi(kotlin.coroutines.core)
        testImplementation(kotlin.coroutines.test)
        testImplementation(kotlintest.core)
        testImplementation(kotlintest.junit5)
        testImplementation(assertj)
        testImplementation(hamcrest)
        testImplementation(mockk)
        testImplementation(mockito)
        testImplementation(mockito.kotlin)
        testImplementation(logback)
        testImplementation(logback.classic)
        testImplementation(rxjava)
        testImplementation(kotlin.serialization.json)
        testImplementation(kotest)
        testImplementation(kotest.assertions)
        testImplementation(kotest.property)
        testImplementation(okhttp.mockwebserver)
    }
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
