package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class MinimumPathSumTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, Array<IntArray>>> {
            return listOf(
                7 to arrayOf(
                    intArrayOf(1, 3, 1),
                    intArrayOf(1, 5, 1),
                    intArrayOf(4, 2, 1)
                ),
                6 to arrayOf(
                    intArrayOf(1, 1, 2),
                    intArrayOf(1, 1, 3),
                    intArrayOf(4, 2, 1)
                ),
                83 to arrayOf(
                    intArrayOf(3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3),
                    intArrayOf(0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2),
                    intArrayOf(8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9),
                    intArrayOf(1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7),
                    intArrayOf(8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8),
                    intArrayOf(4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9),
                    intArrayOf(6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1),
                    intArrayOf(8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3),
                    intArrayOf(9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3),
                    intArrayOf(0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8),
                    intArrayOf(4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3),
                    intArrayOf(2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3),
                    intArrayOf(0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3),
                    intArrayOf(0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5),
                    intArrayOf(6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2),
                    intArrayOf(7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0),
                    intArrayOf(3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0),
                    intArrayOf(5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `min path sum test`(testCase: Pair<Int, Array<IntArray>>) {
        val (expected, matrix) = testCase
        val actual = minPathSum(matrix)
        assertEquals(expected, actual)
    }
}
