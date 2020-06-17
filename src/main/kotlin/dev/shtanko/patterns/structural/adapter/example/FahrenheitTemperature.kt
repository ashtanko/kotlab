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

    private fun convertFahrenheitToCelsius(f: Double): Double =
        (f - SCALE) * RISE / RATE

    private fun convertCelsiusToFahrenheit(c: Double): Double = (c * RATE / RISE) + SCALE
}
