package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class SubArraySumStrategyTest<out T : SubarraySumStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 1, 1)
        val k = 2
        assertEquals(2, strategy.perform(arr, k))
    }
}

class SubArraySumBruteForceTest : SubArraySumStrategyTest<SubarraySumBruteForce>(SubarraySumBruteForce())

class SubArraySumUsingCumulativeSumTest :
    SubArraySumStrategyTest<SubarraySumUsingCumulativeSum>(SubarraySumUsingCumulativeSum())

class SubArraySumWithoutSpaceTest : SubArraySumStrategyTest<SubarraySumWithoutSpace>(SubarraySumWithoutSpace())

class SubArraySumUsingHashmapTest : SubArraySumStrategyTest<SubarraySumUsingHashmap>(SubarraySumUsingHashmap())
