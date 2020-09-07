package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationSumTest {

    @ExperimentalStdlibApi
    @Test
    fun `simple test`() {
        val candidates = intArrayOf(2, 3, 6, 7)
        val target = 7
        val actual = combinationSum(candidates, target)
        assertEquals(listOf(listOf(2, 2, 3), listOf(7)), actual)
    }

    @ExperimentalStdlibApi
    @Test
    fun `simple test 2`() {
        val candidates = intArrayOf(2, 3, 5)
        val target = 8
        val actual = combinationSum(candidates, target)
        assertEquals(listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)), actual)
    }
}
