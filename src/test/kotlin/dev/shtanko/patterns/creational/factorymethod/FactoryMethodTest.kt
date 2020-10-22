package dev.shtanko.patterns.creational.factorymethod

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FactoryMethodTest {

    @Test
    fun `factory method test`() {
        val greeceCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        println("Greece currency: $greeceCurrency")

        val usaCurrency = CurrencyFactory.currencyForCountry(Country.USA).code
        println("USA currency: $usaCurrency")

        assertThat(greeceCurrency).isEqualTo("EUR")
        assertThat(usaCurrency).isEqualTo("USD")
    }
}
