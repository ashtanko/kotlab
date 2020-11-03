package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ShortestSubArrayTest {

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
    fun `shortest sub array test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val expected = testCase.second
        val actual = shortestSubarray(testCase.first.first, testCase.first.second)
        assertEquals(expected, actual)
    }
}
