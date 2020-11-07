package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class UncrossedLinesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, Int>> {
            return listOf(
                intArrayOf(1, 4, 2) to intArrayOf(1, 2, 4) to 2,
                intArrayOf(2, 5, 1, 2, 5) to intArrayOf(10, 5, 2, 1, 5, 2) to 3,
                intArrayOf(1, 3, 7, 1, 7, 5) to intArrayOf(1, 9, 2, 5, 1) to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `max uncrossed lines test`(testCase: Pair<Pair<IntArray, IntArray>, Int>) {
        val numbers = testCase.first
        val actual = numbers.maxUncrossedLines()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
