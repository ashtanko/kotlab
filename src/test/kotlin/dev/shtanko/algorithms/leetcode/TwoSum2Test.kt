package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class TwoSum2Test {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                intArrayOf(2, 7, 11, 15) to 9 to intArrayOf(1, 2),
                intArrayOf(4, 8, 15, 16, 23, 42) to 16 to intArrayOf(2, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `two sum 2 test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val arr = testCase.first.first
        val target = testCase.first.second
        val actual = arr.twoSum2(target)
        val expected = testCase.second
        assertArrayEquals(expected, actual)
    }
}
