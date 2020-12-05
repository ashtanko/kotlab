package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RemoveDuplicatesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(1, 1, 2) to 2,
                intArrayOf(4, 8, 15) to 3,
                intArrayOf(1, 1, 1, 1, 1) to 1,
                intArrayOf() to 0,
                intArrayOf(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1) to 5
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `remove duplicates test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.removeDuplicates()
        assertEquals(expected, actual)
    }
}
