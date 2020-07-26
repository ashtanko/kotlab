import extensions.testImplementation

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = "dev.shtanko.hawk"
        minSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
        testInstrumentationRunnerArguments =
            BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER_ARGUMENTS
        buildConfigField(
            "String",
            "SPOTIFY_CLIENT_ID",
            "\"f52a3938003c49278bafb596607783d8\""
        )

        buildConfigField(
            "String",
            "SPOTIFY_REDIRECT_URI",
            "\"https://shtanko.dev/callback\""
        )
    }

    buildFeatures {
        viewBinding = BuildAndroidConfig.VIEW_BINDING
    }

    buildTypes {
        getByName(BuildType.DEBUG) {
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
        }

        getByName(BuildType.RELEASE) {
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
            postprocessing.apply {
                proguardFiles("proguard-rules.pro")
                isOptimizeCode = BuildTypeRelease.isOptimizeCode
                isObfuscate = BuildTypeRelease.isObfuscate
                isRemoveUnusedCode = BuildTypeRelease.isRemoveUnusedCode
                isRemoveUnusedResources = BuildTypeRelease.isRemoveUnusedResources
            }
        }
    }

    dexOptions {
        javaMaxHeapSize = "2g"
    }

    lintOptions {
        lintConfig = rootProject.file("app/.lint/config.xml")
        // Eliminates UnusedResources false positives for resources used in DataBinding layouts
        isCheckGeneratedSources = true
        // Running lint over the debug variant is enough
        isCheckReleaseBuilds = false
        // See lint.xml for rules configuration
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("licenses/javolution.license.TXT")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/*.kotlin_module")
        exclude("org/apache/http/version.properties")
        exclude("org/apache/maven/*.*")
        exclude("org/apache/maven/*")
        exclude("org/cyberneko/html/*")
        exclude("org/cyberneko/html/*.*")
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // To avoid the compile error: "Cannot inline bytecode built with JVM target 1.8
    // into bytecode that is being built with JVM target 1.6"
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.aar"))))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("com.google.android.material:material:1.1.0")

    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.fragment:fragment-ktx:1.2.5")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.palette:palette:1.0.0")
    implementation("androidx.customview:customview:1.1.0")
    implementation("androidx.drawerlayout:drawerlayout:1.1.0")
    implementation("androidx.core:core:1.3.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.2.0")


    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    testImplementation("junit:junit:4.13")

    testImplementation("com.nhaarman:mockito-kotlin:1.6.0")
    testImplementation("org.mockito:mockito-android:3.0.0")
    testImplementation("org.mockito:mockito-core:3.3.3")
    // testImplementation("org.robolectric:robolectric:4.3.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.3.72")
    testImplementation("android.arch.core:core-testing:1.1.1")

    androidTestImplementation("androidx.test:rules:1.2.0")
    androidTestImplementation("androidx.test:runner:1.2.0")
    debugImplementation("androidx.fragment:fragment-testing:1.2.5")
    androidTestImplementation("org.assertj:assertj-core:3.16.1")
    androidTestUtil("androidx.test:orchestrator:1.2.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    implementation(project(":mobile:core"))
    implementation(project(":mobile:mvi-base"))
    //implementation(project(":mobile:testing"))

    testImplementation(TestDependencies.MOCKK)
    implementation(TestDependencies.MOCK_WEB_SERVER)
}
