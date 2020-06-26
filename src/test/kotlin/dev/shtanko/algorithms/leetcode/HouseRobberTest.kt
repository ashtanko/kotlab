package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractRobberTest<out T : AbstractRobberStrategy>(private val strategy: T) {
    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3, 1)
        assertEquals(4, strategy.perform(arr))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(2, 7, 9, 3, 1)
        assertEquals(12, strategy.perform(arr))
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(4, 8, 15, 16, 23, 42)
        assertEquals(66, strategy.perform(arr))
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1, 1, 1, 1, 1, 1)
        assertEquals(3, strategy.perform(arr))
    }

    @Test
    fun `simple test 6`() {
        val arr = intArrayOf(1, 0, 1, 0, 1, 0, 1)
        assertEquals(4, strategy.perform(arr))
    }
}

class RecursiveRobberTest : AbstractRobberTest<RecursiveRobber>(RecursiveRobber())

class RecursiveRobberMemoTest : AbstractRobberTest<RecursiveRobberMemo>(RecursiveRobberMemo())

class IterativeRobberMemoTest : AbstractRobberTest<IterativeRobberMemo>(IterativeRobberMemo())

class IterativeRobberTest : AbstractRobberTest<IterativeRobber>(IterativeRobber())
