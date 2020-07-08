package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(2, 2, 1)
        assertEquals(1, arr.singleNumber())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(4, 1, 2, 1, 2)
        assertEquals(4, arr.singleNumber())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(2, 2, 1)
        assertEquals(1, arr.singleNumberUsingSet())
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(4, 1, 2, 1, 2)
        assertEquals(4, arr.singleNumberUsingSet())
    }
}
