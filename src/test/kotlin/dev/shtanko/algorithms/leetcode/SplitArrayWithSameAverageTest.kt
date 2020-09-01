package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SplitArrayWithSameAverageTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        assertTrue(arr.splitArraySameAverage())
    }
}
