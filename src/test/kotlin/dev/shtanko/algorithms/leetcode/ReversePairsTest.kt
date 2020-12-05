package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ReversePairsTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf() to 0,
                intArrayOf(1, 3, 2, 3, 1) to 2,
                intArrayOf(2, 4, 3, 5, 1) to 3
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `reverse pairs BST test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.reversePairsBST()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `reverse pairs BIT 2 test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = arr.reversePairsBIT()
        assertEquals(expected, actual)
    }
}
