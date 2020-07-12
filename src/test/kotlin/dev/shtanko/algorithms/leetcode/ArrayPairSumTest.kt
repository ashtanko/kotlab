package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ArrayPairSumTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 4, 3, 2)
        assertEquals(4, arr.pairSum())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 4, 3, 2)
        assertEquals(4, arr.pairSum2())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 4, 3, 2)
        assertEquals(4, arr.pairSum3())
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1, 4, 3, 2)
        assertEquals(4, arr.pairSum4())
    }
}
