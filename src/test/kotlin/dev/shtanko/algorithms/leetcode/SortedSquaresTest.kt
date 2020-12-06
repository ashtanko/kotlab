package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class SortedSquaresTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(-4, -1, 0, 3, 10) to intArrayOf(0, 1, 9, 16, 100),
                intArrayOf(-7, -3, 2, 3, 11) to intArrayOf(4, 9, 9, 49, 121),
                intArrayOf(-4, -1, 0, 3, 10) to intArrayOf(0, 1, 9, 16, 100),
                intArrayOf(-7, -3, 2, 3, 11) to intArrayOf(4, 9, 9, 49, 121)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `sorted squares test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        val actual = arr.sortedSquares()
        assertArrayEquals(expected, actual)
    }
}
