package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ElementPositionTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, IntArray>, IntArray>> {
            return listOf(
                4 to intArrayOf() to intArrayOf(-1, -1),
                8 to intArrayOf(5, 7, 7, 8, 8, 10) to intArrayOf(3, 4),
                6 to intArrayOf(5, 7, 7, 8, 8, 10) to intArrayOf(-1, -1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `search range test`(testCase: Pair<Pair<Int, IntArray>, IntArray>) {
        val (data, expected) = testCase
        val (target, arr) = data
        val actual = arr.searchRange(target)
        assertThat(actual, equalTo(expected))
    }
}
