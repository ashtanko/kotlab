package dev.shtanko.patterns.creational.abstractfactory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AbstractFactoryTest {

    @Test
    fun `abstract factory test`() {
        val plantFactory = PlantFactory.createFactory<OrangePlant>()
        val plant = plantFactory.makePlant()
        println("Created plant: $plant")

        assertThat(plant).isInstanceOf(OrangePlant::class.java)
    }
}
