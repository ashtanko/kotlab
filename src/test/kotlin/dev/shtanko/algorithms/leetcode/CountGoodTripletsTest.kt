package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodTripletsTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(3, 0, 1, 1, 9, 7)
        val a = 7
        val b = 2
        val c = 3
        val expected = 4
        assertEquals(expected, countGoodTriplets(arr, a, b, c))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 1, 2, 2, 3)
        val a = 0
        val b = 0
        val c = 1
        val expected = 0
        assertEquals(expected, countGoodTriplets(arr, a, b, c))
    }
}
