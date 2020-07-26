package dev.shtanko.core.utils

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config
import dev.shtanko.testing.TestCompatActivity
import dev.shtanko.testing.robolectric.TestRobolectric

@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ThemeUtilsTest : TestRobolectric() {

    @get:Rule
    val rule = ActivityScenarioRule(TestCompatActivity::class.java)
    private lateinit var scenario: ActivityScenario<TestCompatActivity>

    private var themeUtils = ThemeUtilsImpl()

    @Before
    fun setUp() {
        scenario = rule.scenario
    }

    @Test
    fun configuredAppNightMode_ShouldDarkTheme() {
        scenario.onActivity {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            it.delegate.applyDayNight()

            assertTrue(themeUtils.isDarkTheme(it))
        }
    }

    @Test
    fun configuredAppNightMode_ShouldNotLightTheme() {
        scenario.onActivity {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            it.delegate.applyDayNight()

            assertFalse(themeUtils.isLightTheme(it))
        }
    }

    @Test
    fun configuredAppNoNightMode_ShouldBeLightTheme() {
        scenario.onActivity {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            it.delegate.applyDayNight()

            assertTrue(themeUtils.isLightTheme(it))
        }
    }

    @Test
    fun configuredAppNoNightMode_ShouldBeNotDarkTheme() {
        scenario.onActivity {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            it.delegate.applyDayNight()

            assertFalse(themeUtils.isDarkTheme(it))
        }
    }

    @Test
    fun forceAppNightMode_ShouldBeDarkTheme() {
        scenario.onActivity {
            themeUtils.setNightMode(true)
            it.delegate.applyDayNight()

            assertTrue(themeUtils.isDarkTheme(it))
        }
    }

    @Test
    fun forceAppNoNightMode_ShouldBeLightTheme() {
        scenario.onActivity {
            themeUtils.setNightMode(false)
            it.delegate.applyDayNight()

            assertTrue(themeUtils.isLightTheme(it))
        }
    }
}
