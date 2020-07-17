package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractNumIdenticalPairsTest<T : AbstractNumIdenticalPairs>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3, 1, 1, 3)
        assertEquals(4, strategy.perform(arr))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 1, 1, 1)
        assertEquals(6, strategy.perform(arr))
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 2, 3)
        assertEquals(0, strategy.perform(arr))
    }
}

class NumIdenticalPairsNaiveTest : AbstractNumIdenticalPairsTest<NumIdenticalPairsNaive>(NumIdenticalPairsNaive())

class NumIdenticalPairsMapTest : AbstractNumIdenticalPairsTest<NumIdenticalPairsMap>(NumIdenticalPairsMap())

class NumIdenticalPairsSortTest : AbstractNumIdenticalPairsTest<NumIdenticalPairsSort>(NumIdenticalPairsSort())
