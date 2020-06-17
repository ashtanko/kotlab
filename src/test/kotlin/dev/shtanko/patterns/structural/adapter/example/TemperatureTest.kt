package dev.shtanko.patterns.structural.adapter.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TemperatureTest {

    private val celsiusTemperature = CelsiusTemperature(0.0)
    private val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)

    @Test
    fun `celsius to fahrenheit test`() {
        celsiusTemperature.temperature = 36.6
        assertEquals(97.88, fahrenheitTemperature.temperature)
    }

    @Test
    fun `fahrenheit to celsius test`() {
        fahrenheitTemperature.temperature = 100.0
        assertEquals(37.77777777777778, celsiusTemperature.temperature)
    }
}
