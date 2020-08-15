package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PascalsTriangleTest {

    @Test
    fun `simple test`() {
        val actual = 5.pascalsTriangle()
        val expected = listOf(
            listOf(1),
            listOf(1, 1),
            listOf(1, 2, 1),
            listOf(1, 3, 3, 1),
            listOf(1, 4, 6, 4, 1)
        )
        assertEquals(expected, actual)
    }
}
