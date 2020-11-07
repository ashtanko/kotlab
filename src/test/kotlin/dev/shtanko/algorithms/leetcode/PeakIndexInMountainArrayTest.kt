package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class PeakIndexInMountainArrayTest<out T : PeakIndexInMountainArrayStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(0, 1, 0) to 1,
                intArrayOf(0, 2, 1, 0) to 1,
                intArrayOf(0, 10, 5, 2) to 1,
                intArrayOf(3, 4, 5, 1) to 2,
                intArrayOf(24, 69, 100, 99, 79, 78, 67, 36, 26, 19) to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `peak index in mountain test`(testCase: Pair<IntArray, Int>) {
        val arr = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

class PeakIndexInMountainArrayLinearScanTest :
    PeakIndexInMountainArrayTest<PeakIndexInMountainArrayLinearScan>(PeakIndexInMountainArrayLinearScan())

class PeakIndexInMountainArrayBinarySearchTest :
    PeakIndexInMountainArrayTest<PeakIndexInMountainArrayBinarySearch>(PeakIndexInMountainArrayBinarySearch())

class PeakIndexInMountainArrayBetterThanBinarySearchTest :
    PeakIndexInMountainArrayTest<PeakIndexInMountainArrayBetterThanBinarySearch>(
        PeakIndexInMountainArrayBetterThanBinarySearch()
    )
