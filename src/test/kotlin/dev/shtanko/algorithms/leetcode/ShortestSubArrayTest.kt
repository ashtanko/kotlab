package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ShortestSubArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                Pair(Pair(intArrayOf(1), 1), 1),
                Pair(Pair(intArrayOf(1, 2), 4), -1),
                Pair(Pair(intArrayOf(2, -1, 2), 3), 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `shortest sub array test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val (data, expected) = testCase
        val (a, k) = data
        val actual = shortestSubarray(a, k)
        assertEquals(expected, actual)
    }
}
