pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://repo.kotlin.link") }
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google()
        mavenCentral()
        mavenCentral()
        maven { url = uri("https://repo.kotlin.link") }
        gradlePluginPortal()
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "kotlab"
