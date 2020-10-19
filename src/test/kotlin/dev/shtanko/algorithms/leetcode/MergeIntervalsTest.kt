package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class MergeIntervalsStrategyTest<out T : MergeIntervalsStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Array<IntArray>, Array<IntArray>>> {
            return listOf(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18)
                ) to arrayOf(
                    intArrayOf(1, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `merge intervals test`(testCase: Pair<Array<IntArray>, Array<IntArray>>) {
        val intervals = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(intervals)
        assertArrayEquals(expected, actual)
    }
}

class MergeIntervalsConnectedComponentsTest :
    MergeIntervalsStrategyTest<MergeIntervalsConnectedComponents>(MergeIntervalsConnectedComponents())

class MergeIntervalsSortingTest :
    MergeIntervalsStrategyTest<MergeIntervalsSorting>(MergeIntervalsSorting())
