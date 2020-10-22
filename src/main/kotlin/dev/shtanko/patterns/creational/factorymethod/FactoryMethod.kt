package dev.shtanko.patterns.creational.factorymethod

sealed class Country {
    object USA : Country()
}

object Spain : Country()
class Greece(val someProperty: String) : Country()
data class Canada(val someProperty: String) : Country()
// object Poland : Country()

class Currency(
    val code: String
)

object CurrencyFactory {

    fun currencyForCountry(country: Country): Currency =
        when (country) {
            is Greece -> Currency("EUR")
            is Spain -> Currency("EUR")
            is Country.USA -> Currency("USD")
            is Canada -> Currency("CAD")
        }
}
