package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractCountNegativesTest<out T : AbstractCountNegativesStrategy>(private val strategy: T) {
    @Test
    fun `simple test`() {
        val grid = arrayOf(
            intArrayOf(4, 3, 2, -1),
            intArrayOf(3, 2, 1, -1),
            intArrayOf(1, 1, -1, -2),
            intArrayOf(-1, -1, -2, -3)
        )

        val actual = strategy.perform(grid)
        assertEquals(8, actual)
    }

    @Test
    fun `simple test 2`() {
        val grid = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(1, 0)
        )

        val actual = strategy.perform(grid)
        assertEquals(0, actual)
    }

    @Test
    fun `simple test 3`() {
        val grid = arrayOf(
            intArrayOf(1, -1),
            intArrayOf(-1, -1)
        )

        val actual = strategy.perform(grid)
        assertEquals(3, actual)
    }

    @Test
    fun `simple test 4`() {
        val grid = arrayOf(
            intArrayOf(-1)
        )

        val actual = strategy.perform(grid)
        assertEquals(1, actual)
    }
}

class SimpleCountNegativesTest : AbstractCountNegativesTest<SimpleCountNegatives>(SimpleCountNegatives())

class CountNegativesTwoPointersTest : AbstractCountNegativesTest<CountNegativesTwoPointers>(CountNegativesTwoPointers())

class CountNegativesBinaryTest : AbstractCountNegativesTest<CountNegativesBinary>(CountNegativesBinary())
