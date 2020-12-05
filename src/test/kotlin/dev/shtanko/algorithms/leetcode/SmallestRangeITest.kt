package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class SmallestRangeITest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                Pair(Pair(intArrayOf(1), 0), 0),
                Pair(Pair(intArrayOf(0, 10), 2), 6),
                Pair(Pair(intArrayOf(1, 3, 6), 3), 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `smallest range I test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val (data, expected) = testCase
        val actual = data.smallestRangeI()
        assertEquals(expected, actual)
    }
}
