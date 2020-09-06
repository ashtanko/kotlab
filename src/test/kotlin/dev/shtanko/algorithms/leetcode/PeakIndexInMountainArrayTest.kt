package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class PeakIndexInMountainArrayTest<out T : PeakIndexInMountainArrayStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(0, 1, 0)
        assertEquals(1, strategy.perform(arr))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(0, 2, 1, 0)
        assertEquals(1, strategy.perform(arr))
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(0, 10, 5, 2)
        assertEquals(1, strategy.perform(arr))
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(3, 4, 5, 1)
        assertEquals(2, strategy.perform(arr))
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(24, 69, 100, 99, 79, 78, 67, 36, 26, 19)
        assertEquals(2, strategy.perform(arr))
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
