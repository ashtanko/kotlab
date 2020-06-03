package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextPermutationTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3)
        arr.nextPermutation()
        assertArrayEquals(intArrayOf(1, 3, 2), arr)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(3, 2, 1)
        arr.nextPermutation()
        assertArrayEquals(intArrayOf(1, 2, 3), arr)
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 1, 5)
        arr.nextPermutation()
        assertArrayEquals(intArrayOf(1, 5, 1), arr)
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1, 3, 2)
        arr.nextPermutation()
        assertArrayEquals(intArrayOf(2, 1, 3), arr)
    }

}