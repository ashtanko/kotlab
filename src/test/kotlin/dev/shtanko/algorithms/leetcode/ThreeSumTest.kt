package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSumTest {
    @Test
    fun `no solution test`() {
        val array = intArrayOf(0, 0, 1)
        val result = array.threeSum()
        Assertions.assertTrue(result.isEmpty())
    }

    @Test
    fun `solution test`() {
        val array = intArrayOf(-1, 0, 1, 2, -1, -4)
        val result = array.threeSum()
        val actual = listOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
        assertEquals(result, actual)
    }
}