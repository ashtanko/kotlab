package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class MajorityElementTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(3, 2, 3) to 3,
                intArrayOf(2, 2, 1, 1, 1, 2, 2) to 2,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `majority element test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.majorityElement()
        assertEquals(expected, actual)
    }
}
