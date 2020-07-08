package dev.shtanko.algorithms.extensions

import android.content.Context
import android.content.res.Configuration

/**
 * Whether the current configuration is a dark theme i.e. in Night configuration.
 */
fun Context.isDarkTheme(): Boolean {
    return (resources.configuration.uiMode
            and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}
