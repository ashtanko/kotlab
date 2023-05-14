package dev.shtanko.patterns.structural.adapter.examples.figures

import dev.shtanko.patterns.structural.adapter.examples.figures.round.RoundPeg
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RoundPegTest {

    @Test
    fun `test round peg radius is set correctly`() {
        // Arrange
        val radius = 5.0
        val roundPeg = RoundPeg(radius)
        // Act
        val actualRadius = roundPeg.radius
        // Assert
        assertEquals(radius, actualRadius, 0.0)
    }

    @Test
    fun `test round peg radius is updated correctly`() {
        // Arrange
        val initialRadius = 2.0
        val updatedRadius = 5.0
        val roundPeg = RoundPeg(initialRadius)
        // Act
        roundPeg.radius = updatedRadius
        val actualRadius = roundPeg.radius
        // Assert
        assertEquals(updatedRadius, actualRadius, 0.0)
    }
}
