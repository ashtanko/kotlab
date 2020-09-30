package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TriangleTest {

    @Test
    fun `simple test`() {
        val triangle = listOf(
            listOf(2),
            listOf(3, 4),
            listOf(6, 5, 7),
            listOf(4, 1, 8, 3)
        )
        val actual = minimumTotal(triangle)
        assertEquals(11, actual)
    }
}
