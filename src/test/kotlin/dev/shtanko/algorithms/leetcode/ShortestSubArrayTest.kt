package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ShortestSubArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                (intArrayOf(1) to 1) to 1,
                (intArrayOf(1, 2) to 4) to -1,
                (intArrayOf(2, -1, 2) to 3) to 3
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
