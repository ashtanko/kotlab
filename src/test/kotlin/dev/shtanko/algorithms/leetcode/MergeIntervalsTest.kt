package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

abstract class MergeIntervalsStrategyTest<out T : MergeIntervalsStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val intervals = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        )
        val actual = strategy.perform(intervals)
        assertArrayEquals(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            ), actual
        )
    }
}

class MergeIntervalsConnectedComponentsTest :
    MergeIntervalsStrategyTest<MergeIntervalsConnectedComponents>(MergeIntervalsConnectedComponents())

class MergeIntervalsSortingTest :
    MergeIntervalsStrategyTest<MergeIntervalsSorting>(MergeIntervalsSorting())
