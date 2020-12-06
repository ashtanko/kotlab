package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class CombinationSumTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, List<List<Int>>>> {
            return listOf(
                intArrayOf(2, 3, 6, 7) to 7 to listOf(listOf(2, 2, 3), listOf(7)),
                intArrayOf(2, 3, 5) to 8 to listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5))
            )
        }
    }

    @ExperimentalStdlibApi
    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `combination sum test`(testCase: Pair<Pair<IntArray, Int>, List<List<Int>>>) {
        val (data, expected) = testCase
        val (candidates, target) = data
        val actual = combinationSum(candidates, target)
        assertEquals(expected, actual)
    }
}
