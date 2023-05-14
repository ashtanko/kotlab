package dev.shtanko.patterns.structural.adapter.examples.figures

import dev.shtanko.patterns.structural.adapter.examples.figures.adapters.SquarePegAdapter
import dev.shtanko.patterns.structural.adapter.examples.figures.square.SquarePeg
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SquarePegAdapterTest {

    @Test
    fun `test adapter converts square peg to round peg`() {
        // Arrange
        val squarePeg = SquarePeg(5.0)
        val adapter = SquarePegAdapter(squarePeg)
        // Act
        val actualRadius = adapter.radius
        // Assert
        assertEquals(3.536, actualRadius, 0.001)
    }
}
