package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindNumbersWithEvenNumberOfDigitsTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(12, 345, 2, 6, 7896)
        assertEquals(2, arr.findNumbers())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(555, 901, 482, 1771)
        assertEquals(1, arr.findNumbers())
    }
}
