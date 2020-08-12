package dev.shtanko.core.utils

import androidx.appcompat.app.AppCompatDelegate
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dev.shtanko.testing.TestCompatActivity
import dev.shtanko.testing.robolectric.TestRobolectric
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

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
    fun `force app no night mode should be light theme`() {
        scenario.onActivity {
            themeUtils.setNightMode(false)
            it.delegate.applyDayNight()

            assertTrue(themeUtils.isLightTheme(it))
        }
    }

    @Test
    fun configuredAppNightMode_ShouldNotLightTheme() {
        scenario.onActivity {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            it.delegate.applyDayNight()

            Assert.assertFalse(themeUtils.isLightTheme(it))
        }
    }
}
