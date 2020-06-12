package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchInsertPosition {

    @Test
    fun `empty array test`() {
        val arr = intArrayOf()
        val target = 1
        val actual = arr.searchInsertPosition(target)
        assertEquals(0, actual)
    }

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 3, 5, 6)
        val target = 5
        val actual = arr.searchInsertPosition(target)
        assertEquals(2, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 3, 5, 6)
        val target = 2
        val actual = arr.searchInsertPosition(target)
        assertEquals(1, actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 3, 5, 6)
        val target = 7
        val actual = arr.searchInsertPosition(target)
        assertEquals(4, actual)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1, 3, 5, 6)
        val target = 0
        val actual = arr.searchInsertPosition(target)
        assertEquals(0, actual)
    }
}
