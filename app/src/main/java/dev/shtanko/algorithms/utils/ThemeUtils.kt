package dev.shtanko.algorithms.utils

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

/**
 * Utils interface for application theme configuration.
 */
interface ThemeUtils {

    /**
     * Whether the current configuration is a dark theme i.e. in Night configuration.
     */
    fun isDarkTheme(context: Context): Boolean

    /**
     * Whether the current configuration is a light theme i.e. in Day configuration.
     */
    fun isLightTheme(context: Context): Boolean

    /**
     * Force [AppCompatDelegate] Mode to night/notnight.
     *
     * @param forceNight Boolean that force night mode otherwise notnight is configured.
     * @param delay Delay to apply mode changes.
     */
    fun setNightMode(forceNight: Boolean, delay: Long = 0L)
}
