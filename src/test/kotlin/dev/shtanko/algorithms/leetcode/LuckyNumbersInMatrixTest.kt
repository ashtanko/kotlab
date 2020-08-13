package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractLuckyNumbersStrategyTest<out T : AbstractLuckyNumbersStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val matrix = arrayOf(
            intArrayOf(3, 7, 8),
            intArrayOf(9, 11, 13),
            intArrayOf(15, 16, 17)
        )
        assertEquals(listOf(15), strategy.perform(matrix))
    }

    @Test
    fun `simple test 2`() {
        val matrix = arrayOf(
            intArrayOf(1, 10, 4, 2),
            intArrayOf(9, 3, 8, 7),
            intArrayOf(15, 16, 17, 12)
        )
        assertEquals(listOf(12), strategy.perform(matrix))
    }

    @Test
    fun `simple test 3`() {
        val matrix = arrayOf(
            intArrayOf(7, 8),
            intArrayOf(1, 2)
        )
        assertEquals(listOf(7), strategy.perform(matrix))
    }
}

class LuckyNumbersTest : AbstractLuckyNumbersStrategyTest<LuckyNumbers>(LuckyNumbers())

class LuckyNumbersSetTest : AbstractLuckyNumbersStrategyTest<LuckyNumbersSet>(LuckyNumbersSet())
