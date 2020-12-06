package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DuplicateZerosTest {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(1, 0, 2, 3, 0, 4, 5, 0) to intArrayOf(1, 0, 0, 2, 3, 0, 0, 4),
                intArrayOf(1, 2, 3) to intArrayOf(1, 2, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `duplicate zeros test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        duplicateZeros(arr)
        assertArrayEquals(expected, arr)
    }
}
