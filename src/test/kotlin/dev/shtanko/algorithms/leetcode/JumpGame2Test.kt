package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class JumpGame2Test {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> = listOf(
            intArrayOf(2, 3, 1, 1, 4) to 2,
            intArrayOf(4, 8, 15, 16, 23, 42) to 2,
            intArrayOf() to 0,
            intArrayOf(1) to 0,
            intArrayOf(1, 1) to 1,
            intArrayOf(1, 2) to 1,
            intArrayOf(1, 1, 1) to 2
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `jump test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.jump()
        assertEquals(expected, actual)
    }
}
