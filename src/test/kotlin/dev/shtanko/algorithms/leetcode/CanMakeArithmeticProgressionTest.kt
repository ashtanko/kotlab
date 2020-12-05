package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class CanMakeArithmeticProgressionTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                true to intArrayOf(3, 5, 1),
                false to intArrayOf(1, 2, 4),
                false to intArrayOf(0, 1, 4, 9, 16, 25, 36)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `can make arithmetic progression test`(param: Pair<Boolean, IntArray>) {
        val (expected, arr) = param
        val actual = arr.canMakeArithmeticProgression()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `can make arithmetic progression using set test`(param: Pair<Boolean, IntArray>) {
        val (expected, arr) = param
        val actual = arr.canMakeArithmeticProgressionSet()
        assertEquals(expected, actual)
    }
}
