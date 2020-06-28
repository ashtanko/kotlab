package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(3, 2, 3)
        val actual = arr.majorityElement()
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test2`() {
        val arr = intArrayOf(2, 2, 1, 1, 1, 2, 2)
        val actual = arr.majorityElement()
        val expected = 2
        assertEquals(expected, actual)
    }
}
