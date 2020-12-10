package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class FindPeakElementTest<out T : FindPeakElementStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            intArrayOf() to 0,
            intArrayOf(1, 2, 3, 1) to 2,
            intArrayOf(1, 2, 1, 3, 5, 6, 4) to 5,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `find peek element`(testCase: Pair<IntArray, Int>) {
        val (nums, expected) = testCase
        val actual = strategy.perform(nums)
        assertEquals(expected, actual)
    }
}

internal class FindPeakElementLinearTest : FindPeakElementTest<FindPeakElementLinear>(FindPeakElementLinear())

internal class FindPeakElementRecursiveBinarySearchTest :
    FindPeakElementTest<FindPeakElementRecursiveBinarySearch>(FindPeakElementRecursiveBinarySearch())

internal class FindPeakElementIterativeBinarySearchTest :
    FindPeakElementTest<FindPeakElementIterativeBinarySearch>(FindPeakElementIterativeBinarySearch())
