package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoSumTest {

    @Test
    fun `no solution test`() {
        val array = intArrayOf(4, 8, 15, 16, 23)
        val target = 9
        val result = array.twoSum(target)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `target found test`() {
        val array = intArrayOf(4, 8, 15, 16, 23)
        val target = 12
        val result = array.twoSum(target)
        assertArrayEquals(intArrayOf(0, 1), result)
    }

    @Test
    fun `target in the end of array test`() {
        val array = intArrayOf(4, 8, 15, 16, 23)
        val target = 39
        val result = array.twoSum(target)
        assertArrayEquals(intArrayOf(3, 4), result)
    }
}