package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class TwoArraysEqualReversingTest<out T : CanBeEqualStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, IntArray>, Boolean>> {
            return listOf(
                intArrayOf(1, 2, 3, 4) to intArrayOf(2, 4, 1, 3) to true,
                intArrayOf(7) to intArrayOf(7) to true,
                intArrayOf(1, 12) to intArrayOf(12, 1) to true,
                intArrayOf(3, 7, 9) to intArrayOf(3, 7, 11) to false,
                intArrayOf(1, 1, 1, 1, 1) to intArrayOf(1, 1, 1, 1, 1) to true
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `can be equal test`(testCase: Pair<Pair<IntArray, IntArray>, Boolean>) {
        val (data, expected) = testCase
        val (target, arr) = data
        val actual = strategy.perform(target, arr)
        assertEquals(expected, actual)
    }
}

internal class CanBeEqualSortTest : TwoArraysEqualReversingTest<CanBeEqualSort>(CanBeEqualSort())
internal class CanBeEqualMapTest : TwoArraysEqualReversingTest<CanBeEqualMap>(CanBeEqualMap())
