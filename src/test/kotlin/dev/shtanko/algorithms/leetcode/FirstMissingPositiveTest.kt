package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class FirstMissingPositiveTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(1, 2, 0) to 3,
                intArrayOf(3, 4, -1, 1) to 2,
                intArrayOf(7, 8, 9, 11, 12) to 1,
                intArrayOf(1, 2, 3, 4) to 5
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `first missing positive test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.firstMissingPositive()
        assertEquals(expected, actual)
    }
}
