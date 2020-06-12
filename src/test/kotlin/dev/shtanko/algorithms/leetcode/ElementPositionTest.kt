package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ElementPositionTest {

    @Test
    fun `empty test`() {
        val arr = intArrayOf()
        val target = 4
        val actual = arr.searchRange(target)
        assertArrayEquals(intArrayOf(-1, -1), actual)
    }

    @Test
    fun `simple test`() {
        val arr = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 8
        val actual = arr.searchRange(target)
        assertArrayEquals(intArrayOf(3, 4), actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(5, 7, 7, 8, 8, 10)
        val target = 6
        val actual = arr.searchRange(target)
        assertArrayEquals(intArrayOf(-1, -1), actual)
    }
}
