package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RankTransformArrayTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(40, 10, 20, 30)
        assertArrayEquals(intArrayOf(4, 1, 2, 3), arr.arrayRankTransform())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(100, 100, 100)
        assertArrayEquals(intArrayOf(1, 1, 1), arr.arrayRankTransform())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)
        assertArrayEquals(intArrayOf(5, 3, 4, 2, 8, 6, 7, 1, 3), arr.arrayRankTransform())
    }
}
