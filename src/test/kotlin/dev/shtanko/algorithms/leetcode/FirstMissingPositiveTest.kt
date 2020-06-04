package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class FirstMissingPositiveTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 0)
        val actual = arr.firstMissingPositive()
        assertEquals(3, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(3, 4, -1, 1)
        val actual = arr.firstMissingPositive()
        assertEquals(2, actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(7, 8, 9, 11, 12)
        val actual = arr.firstMissingPositive()
        assertEquals(1, actual)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1,2,3,4)
        val actual = arr.firstMissingPositive()
        assertEquals(5, actual)
    }
}