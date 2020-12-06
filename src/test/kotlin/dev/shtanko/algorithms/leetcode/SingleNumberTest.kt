package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class SingleNumberTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(2, 2, 1) to 1,
                intArrayOf(4, 1, 2, 1, 2) to 4
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `single number test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.singleNumber()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `single number set test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.singleNumberUsingSet()
        assertEquals(expected, actual)
    }
}
