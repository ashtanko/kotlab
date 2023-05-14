package dev.shtanko.patterns.structural.adapter.examples.figures

import dev.shtanko.patterns.structural.adapter.examples.figures.square.SquarePeg
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SquarePegTest {

    @Test
    fun `test square peg square is calculated correctly`() {
        // Arrange
        val width = 5.0
        val squarePeg = SquarePeg(width)
        // Act
        val actualSquare = squarePeg.square
        // Assert
        assertEquals(25.0, actualSquare, 0.0)
    }
}
