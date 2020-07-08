package dev.shtanko.algorithms

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode

class AlgorithmsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setDefaultNightMode(MODE_NIGHT_AUTO_BATTERY)
    }
}
