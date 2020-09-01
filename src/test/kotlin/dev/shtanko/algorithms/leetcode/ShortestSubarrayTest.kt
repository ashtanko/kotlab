package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestSubarrayTest {

    @Test
    fun `simple test`() {
        assertEquals(1, shortestSubarray(intArrayOf(1), 1))
    }

    @Test
    fun `simple test 2`() {
        assertEquals(-1, shortestSubarray(intArrayOf(1, 2), 4))
    }

    @Test
    fun `simple test 3`() {
        assertEquals(3, shortestSubarray(intArrayOf(2, -1, 2), 3))
    }
}
