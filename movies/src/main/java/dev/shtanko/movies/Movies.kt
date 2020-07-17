package dev.shtanko.movies

import android.app.Application
import dev.shtanko.core.utils.ThemeUtils
import dev.shtanko.core.utils.ThemeUtilsImpl

class Movies : Application() {

    private val themeUtils: ThemeUtils by lazy {
        ThemeUtilsImpl()
    }

    override fun onCreate() {
        super.onCreate()
        // themeUtils.setNightMode(true)
    }
}
