package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class SortColorsTest<out T : SortColorsStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            intArrayOf(2, 0, 2, 1, 1, 0) to intArrayOf(0, 0, 1, 1, 2, 2),
            intArrayOf(2, 0, 1) to intArrayOf(0, 1, 2),
            intArrayOf(0) to intArrayOf(0),
            intArrayOf(1) to intArrayOf(1)
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `sort colors test`(testCase: Pair<IntArray, IntArray>) {
        val expected = testCase.second
        val arr = testCase.first
        strategy.perform(arr)
        assertArrayEquals(expected, arr)
    }
}

class SortColorsOnePassTest : SortColorsTest<SortColorsOnePass>(SortColorsOnePass())
class SortColorsTwoPassTest : SortColorsTest<SortColorsTwoPass>(SortColorsTwoPass())
