package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RelativeSortArrayTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> {
            return listOf(
                intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19)
                    to intArrayOf(2, 1, 4, 3, 9, 6)
                    to intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19),
                intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19) to
                    intArrayOf(2, 1, 4, 3, 9, 6) to
                    intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `relative sort array test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val (pair, expected) = testCase
        val actual = pair.relativeSortArray()
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `relative sort array using tree test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val (pair, expected) = testCase
        val actual = pair.relativeSortArrayTree()
        assertArrayEquals(expected, actual)
    }
}
