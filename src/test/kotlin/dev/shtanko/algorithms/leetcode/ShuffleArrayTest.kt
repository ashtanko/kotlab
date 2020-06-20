package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ShuffleArrayTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(2, 5, 1, 3, 4, 7)
        val n = 3
        assertArrayEquals(intArrayOf(2, 3, 5, 4, 1, 7), arr.shuffle(n))
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 2, 3, 4, 4, 3, 2, 1)
        val n = 4
        assertArrayEquals(intArrayOf(1, 4, 2, 3, 3, 2, 4, 1), arr.shuffle(n))
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 1, 2, 2)
        val n = 2
        assertArrayEquals(intArrayOf(1, 2, 1, 2), arr.shuffle(n))
    }
}
