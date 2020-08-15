package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FairCandySwapTest {

    @Test
    fun `simple test`() {
        val a = intArrayOf(1, 1)
        val b = intArrayOf(2, 2)
        assertArrayEquals(intArrayOf(1, 2), (a to b).fairCandySwap())
    }

    @Test
    fun `simple test 2`() {
        val a = intArrayOf(1, 2)
        val b = intArrayOf(2, 3)
        assertArrayEquals(intArrayOf(1, 2), (a to b).fairCandySwap())
    }

    @Test
    fun `simple test 3`() {
        val a = intArrayOf(2)
        val b = intArrayOf(1, 3)
        assertArrayEquals(intArrayOf(2, 3), (a to b).fairCandySwap())
    }

    @Test
    fun `simple test 4`() {
        val a = intArrayOf(1, 2, 5)
        val b = intArrayOf(2, 4)
        assertArrayEquals(intArrayOf(5, 4), (a to b).fairCandySwap())
    }
}
