package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ThirdMaximumNumberTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(3, 2, 1) to 1,
                intArrayOf(1, 2) to 2,
                intArrayOf(2, 2, 3, 1) to 1
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `third max test`(testCase: Pair<IntArray, Int>) {
        val (nums, expected) = testCase
        val actual = thirdMax(nums)
        assertEquals(expected, actual)
    }
}
