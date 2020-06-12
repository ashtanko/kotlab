@file:JvmName("Dependencies")

import Versions.COROUTINES_VERSION

object Dependencies {

    object Kotlin {
        const val STDLIB = "stdlib-jdk8"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
    }

}