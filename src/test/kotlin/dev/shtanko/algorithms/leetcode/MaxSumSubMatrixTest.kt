package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MaxSumSubMatrixTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Pair<Int, Array<IntArray>>, Int>> {
            return listOf(
                2 to arrayOf(
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, -2, 3)
                ) to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `max sum sub matrix test`(testCase: Pair<Pair<Int, Array<IntArray>>, Int>) {
        val matrix = testCase.first.second
        val k = testCase.first.first
        val actual = maxSumSubMatrix(matrix, k)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
