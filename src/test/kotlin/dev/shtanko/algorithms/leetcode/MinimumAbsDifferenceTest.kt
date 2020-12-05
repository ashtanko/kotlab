package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumAbsDifferenceTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<IntArray, List<List<Int>>>> {
            return listOf(
                intArrayOf(4, 2, 1, 3) to listOf(
                    listOf(1, 2),
                    listOf(2, 3),
                    listOf(3, 4)
                ),
                intArrayOf(1, 3, 6, 10, 15) to listOf(
                    listOf(1, 3)
                ),
                intArrayOf(3, 8, -10, 23, 19, -4, -14, 27) to listOf(
                    listOf(-14, -10),
                    listOf(19, 23),
                    listOf(23, 27)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `minimum abs difference test`(testCase: Pair<IntArray, List<List<Int>>>) {
        val (arr, expected) = testCase
        val actual = arr.minimumAbsDifference()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `minimum abs difference 2 test`(testCase: Pair<IntArray, List<List<Int>>>) {
        val (arr, expected) = testCase
        val actual = arr.minimumAbsDifference2()
        assertEquals(expected, actual)
    }
}
