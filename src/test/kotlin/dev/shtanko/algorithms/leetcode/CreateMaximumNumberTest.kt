package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CreateMaximumNumberTest {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Triple<IntArray, IntArray, Int>, IntArray>> {
            return listOf(
                Triple(intArrayOf(3, 4, 6, 5), intArrayOf(9, 1, 2, 5, 8, 3), 5) to intArrayOf(9, 8, 6, 5, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `maximum number test`(testCase: Pair<Triple<IntArray, IntArray, Int>, IntArray>) {
        val nums1 = testCase.first.first
        val nums2 = testCase.first.second
        val k = testCase.first.third
        val expected = testCase.second
        val actual = maxNumber(nums1, nums2, k)
        assertArrayEquals(expected, actual)
    }
}
