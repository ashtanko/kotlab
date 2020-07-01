package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CreateTargetArrayTest {

    @Test
    fun `simple test`() {
        val pair = intArrayOf(0, 1, 2, 3, 4) to intArrayOf(0, 1, 2, 2, 1)
        assertArrayEquals(intArrayOf(0, 4, 1, 3, 2), pair.createTargetArray())
    }

    @Test
    fun `simple test 2`() {
        val pair = intArrayOf(1, 2, 3, 4, 0) to intArrayOf(0, 1, 2, 3, 0)
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), pair.createTargetArray())
    }

    @Test
    fun `simple test 3`() {
        val pair = intArrayOf(1) to intArrayOf(0)
        assertArrayEquals(intArrayOf(1), pair.createTargetArray())
    }

    @Test
    fun `simple test 4`() {
        val pair = intArrayOf(0, 1, 2, 3, 4) to intArrayOf(0, 1, 2, 2, 1)
        assertArrayEquals(intArrayOf(0, 4, 1, 3, 2), pair.createTargetArray2())
    }

    @Test
    fun `simple test 5`() {
        val pair = intArrayOf(1, 2, 3, 4, 0) to intArrayOf(0, 1, 2, 3, 0)
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), pair.createTargetArray2())
    }

    @Test
    fun `simple test 6`() {
        val pair = intArrayOf(1) to intArrayOf(0)
        assertArrayEquals(intArrayOf(1), pair.createTargetArray2())
    }
}
