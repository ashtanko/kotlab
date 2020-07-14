package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RelativeSortArrayTest {

    @Test
    fun `simple test`() {
        val pair = intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19) to intArrayOf(2, 1, 4, 3, 9, 6)
        val actual = pair.relativeSortArray()
        val expected = intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val pair = intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19) to intArrayOf(2, 1, 4, 3, 9, 6)
        val actual = pair.relativeSortArrayTree()
        val expected = intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19)
        assertArrayEquals(expected, actual)
    }
}
