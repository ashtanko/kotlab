package dev.shtanko.algorithms

import android.app.Application
import dev.shtanko.algorithms.utils.ThemeUtils
import dev.shtanko.algorithms.utils.ThemeUtilsImpl

class AlgorithmsApplication : Application() {

    private val themeUtils: ThemeUtils by lazy {
        ThemeUtilsImpl()
    }

    override fun onCreate() {
        super.onCreate()
        themeUtils.setNightMode(true)
    }
}
