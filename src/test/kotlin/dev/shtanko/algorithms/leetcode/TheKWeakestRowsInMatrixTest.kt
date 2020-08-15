package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TheKWeakestRowsInMatrixTest {

    @Test
    fun `simple test`() {
        val matrix =
            arrayOf(
                intArrayOf(1, 1, 0, 0, 0),
                intArrayOf(1, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0),
                intArrayOf(1, 1, 0, 0, 0),
                intArrayOf(1, 1, 1, 1, 1)
            )

        val k = 3
        val data = matrix to k
        assertArrayEquals(intArrayOf(2, 0, 3), data.kWeakestRows())
    }

    @Test
    fun `simple test 2`() {
        val matrix =
            arrayOf(
                intArrayOf(1, 0, 0, 0),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(1, 0, 0, 0),
                intArrayOf(1, 0, 0, 0)
            )

        val k = 2
        val data = matrix to k
        assertArrayEquals(intArrayOf(0, 2), data.kWeakestRows())
    }
}
