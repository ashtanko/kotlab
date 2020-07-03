package dev.shtanko.patterns.structural.adapter.example

class FahrenheitTemperature(private var celsiusTemperature: CelsiusTemperature) : Temperature {

    companion object {
        private const val RISE = 100
        private const val RATE = 180
        private const val SCALE = 32
    }

    override var temperature: Double
        get() = convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        set(temperatureInF) {
            celsiusTemperature.temperature = convertFahrenheitToCelsius(temperatureInF)
        }

    private fun convertFahrenheitToCelsius(f: Double): Double {
        val scaleResult = f - SCALE
        return scaleResult * RISE / RATE
    }

    private fun convertCelsiusToFahrenheit(c: Double): Double {
        val rateRiseResult = c * RATE / RISE
        return rateRiseResult + SCALE
    }
}
