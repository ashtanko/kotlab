package dev.shtanko.patterns.structural.adapter.example

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class TemperatureTest {

    private val celsiusTemperature = CelsiusTemperature(0.0)
    private val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

    @Test
    internal fun `celsius to fahrenheit test`() {
        celsiusTemperature.temperature = 36.6
        val actual = fahrenheitTemperature.temperature
        val expected = 97.88
        assertThat(actual, equalTo(expected))
    }

    @Test
    internal fun `fahrenheit to celsius test`() {
        fahrenheitTemperature.temperature = 100.0
        val actual = celsiusTemperature.temperature
        val expected = 37.77777777777778
        assertThat(actual, equalTo(expected))
    }
}
