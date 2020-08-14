package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

abstract class AbstractSortByParityStrategyTest<out T : AbstractSortByParityStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(4, 2, 5, 7)
        assertArrayEquals(intArrayOf(4, 5, 2, 7), strategy.perform(arr))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 2, 3, 4)
        assertArrayEquals(intArrayOf(2, 1, 4, 3), strategy.perform(arr))
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(4, 8, 15, 16, 23, 41)
        assertArrayEquals(intArrayOf(4, 15, 8, 23, 16, 41), strategy.perform(arr))
    }
}

class SortByParityTwoPassTest : AbstractSortByParityStrategyTest<SortByParityTwoPass>(SortByParityTwoPass())

class SortByParityHeadsTest : AbstractSortByParityStrategyTest<SortByParityHeads>(SortByParityHeads())

class SortByParityStraightForwardTest :
    AbstractSortByParityStrategyTest<SortByParityStraightForward>(SortByParityStraightForward())
