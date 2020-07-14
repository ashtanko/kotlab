package dev.shtanko.algorithms.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate

/**
 * Utils implementation for application theme configuration.
 * @see ThemeUtils
 */
class ThemeUtilsImpl : ThemeUtils {

    /**
     * @see ThemeUtils.isDarkTheme
     */
    override fun isDarkTheme(context: Context) = context.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

    /**
     * @see ThemeUtils.isLightTheme
     */
    override fun isLightTheme(context: Context) = !isDarkTheme(context)

    /**
     * @see ThemeUtils.setNightMode
     */
    override fun setNightMode(forceNight: Boolean, delay: Long) {
        Handler(Looper.getMainLooper()).postDelayed({
            AppCompatDelegate.setDefaultNightMode(
                if (forceNight) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }
            )
        }, delay)
    }
}
