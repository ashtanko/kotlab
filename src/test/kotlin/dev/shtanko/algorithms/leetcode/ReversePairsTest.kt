package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReversePairsTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 3, 2, 3, 1)
        assertEquals(2, arr.reversePairsBST())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(2, 4, 3, 5, 1)
        assertEquals(3, arr.reversePairsBST())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 3, 2, 3, 1)
        assertEquals(2, arr.reversePairsBIT())
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(2, 4, 3, 5, 1)
        assertEquals(3, arr.reversePairsBIT())
    }
}
