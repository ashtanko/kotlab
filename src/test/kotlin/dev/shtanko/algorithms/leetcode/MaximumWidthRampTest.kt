package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class MaximumWidthRampTest<out T : MaximumWidthRampStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val actual = strategy.maxWidthRamp(intArrayOf(6, 0, 8, 2, 1, 5))
        assertEquals(4, actual)
    }

    @Test
    fun `simple test 2`() {
        val actual = strategy.maxWidthRamp(intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1))
        assertEquals(7, actual)
    }
}

class MaximumWidthRampSortTest : MaximumWidthRampTest<MaximumWidthRampSort>(MaximumWidthRampSort())

class MaximumWidthRampBinarySearchTest :
    MaximumWidthRampTest<MaximumWidthRampBinarySearch>(MaximumWidthRampBinarySearch())
