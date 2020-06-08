package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpiralMatrixTest {

    @Test
    fun `simple test`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        val actual = matrix.spiralOrder()
        val expected = listOf(1, 2, 3, 6, 9, 8, 7, 4, 5)

        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )

        val actual = matrix.spiralOrder()
        val expected = listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)

        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )

        val actual = matrix.spiralOrder()
        val expected = listOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)

        assertEquals(expected, actual)
    }

}