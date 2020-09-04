package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class SubarraySumStrategyTest<out T : SubarraySumStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 1, 1)
        val k = 2
        assertEquals(2, strategy.perform(arr, k))
    }
}

class SubarraySumBruteForceTest : SubarraySumStrategyTest<SubarraySumBruteForce>(SubarraySumBruteForce())

class SubarraySumUsingCumulativeSumTest :
    SubarraySumStrategyTest<SubarraySumUsingCumulativeSum>(SubarraySumUsingCumulativeSum())

class SubarraySumWithoutSpaceTest : SubarraySumStrategyTest<SubarraySumWithoutSpace>(SubarraySumWithoutSpace())

class SubarraySumUsingHashmapTest : SubarraySumStrategyTest<SubarraySumUsingHashmap>(SubarraySumUsingHashmap())
