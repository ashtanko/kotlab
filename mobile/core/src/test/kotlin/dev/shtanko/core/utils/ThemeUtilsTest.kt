package dev.shtanko.core.utils

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import dev.shtanko.testing.TestCompatActivity
import dev.shtanko.testing.robolectric.TestRobolectric
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config

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
    fun forceAppNoNightMode_ShouldBeLightTheme() {
        scenario.onActivity {
            themeUtils.setNightMode(false)
            it.delegate.applyDayNight()

            assertTrue(themeUtils.isLightTheme(it))
        }
    }
}
