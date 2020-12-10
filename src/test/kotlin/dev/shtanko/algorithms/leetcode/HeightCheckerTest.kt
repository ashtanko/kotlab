package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class HeightCheckerTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(1, 1, 4, 2, 1, 3) to 3,
                intArrayOf(5, 1, 2, 3, 4) to 5,
                intArrayOf(1, 2, 3, 4, 5) to 0,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `height checker sort test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.heightCheckerSort()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `height checker test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.heightChecker()
        assertEquals(expected, actual)
    }
}
