package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class MaximumWidthRampTest<out T : MaximumWidthRampStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(6, 0, 8, 2, 1, 5) to 4,
                intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1) to 7,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `maximum width ramp test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = strategy.maxWidthRamp(arr)
        assertEquals(expected, actual)
    }
}

internal class MaximumWidthRampSortTest : MaximumWidthRampTest<MaximumWidthRampSort>(MaximumWidthRampSort())

internal class MaximumWidthRampBinarySearchTest :
    MaximumWidthRampTest<MaximumWidthRampBinarySearch>(MaximumWidthRampBinarySearch())
