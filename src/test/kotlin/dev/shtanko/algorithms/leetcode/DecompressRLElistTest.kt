package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DecompressRLElistTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3, 4)
        val actual = arr.decompressRLElist()
        val expected = intArrayOf(2, 4, 4, 4)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 1, 2, 3)
        val actual = arr.decompressRLElist()
        val expected = intArrayOf(1, 3, 3)
        assertArrayEquals(expected, actual)
    }
}
