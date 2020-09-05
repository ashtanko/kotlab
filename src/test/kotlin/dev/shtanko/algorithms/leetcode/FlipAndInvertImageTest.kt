package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FlipAndInvertImageTest {

    @Test
    fun `simple test`() {
        val arr = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0)
        )
        assertArrayEquals(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 1)
            ),
            flipAndInvertImage(arr)
        )
    }

    @Test
    fun `simple test 2`() {
        val arr = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 0, 0, 1),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 0, 1, 0)
        )
        assertArrayEquals(
            arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(0, 1, 1, 0),
                intArrayOf(0, 0, 0, 1),
                intArrayOf(1, 0, 1, 0)
            ),
            flipAndInvertImage(arr)
        )
    }
}
