package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractMinSubsequenceStrategyTest<T : MinSubsequenceStrategy>(val strategy: T) {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(4, 3, 10, 9, 8)
        val actual = strategy.perform(arr)
        val expected = listOf(10, 9)
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(4, 4, 7, 6, 7)
        val actual = strategy.perform(arr)
        val expected = listOf(7, 7, 6)
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(6)
        val actual = strategy.perform(arr)
        val expected = listOf(6)
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1, 1, 1, 1, 1)
        val actual = strategy.perform(arr)
        val expected = listOf(1, 1, 1)
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(1, 1, 1, 1, 1, 3, 5)
        val actual = strategy.perform(arr)
        val expected = listOf(5, 3)
        assertEquals(expected, actual)
    }
}

class MinSubsequenceCountingSortTest :
    AbstractMinSubsequenceStrategyTest<MinSubsequenceCountingSort>(MinSubsequenceCountingSort())

class MinSubsequencePriorityQueueTest :
    AbstractMinSubsequenceStrategyTest<MinSubsequencePriorityQueue>(MinSubsequencePriorityQueue())
