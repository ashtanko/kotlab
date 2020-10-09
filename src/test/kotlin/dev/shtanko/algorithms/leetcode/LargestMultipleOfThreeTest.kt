package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LargestMultipleOfThreeTest {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, String>> {
            return listOf(
                intArrayOf(8, 1, 9) to "981",
                intArrayOf(8, 6, 7, 1, 0) to "8760",
                intArrayOf(1) to "",
                intArrayOf(0, 0, 0, 0, 0, 0) to "0"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<IntArray, String>) {
        val digits = testCase.first
        val expected = testCase.second
        val actual = largestMultipleOfThree(digits)
        assertEquals(expected, actual)
    }
}
