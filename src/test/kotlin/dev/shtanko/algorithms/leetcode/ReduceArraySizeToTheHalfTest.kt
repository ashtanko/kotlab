package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReduceArraySizeToTheHalfTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)
        assertEquals(2, arr.minSetSize())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(7, 7, 7, 7, 7, 7)
        assertEquals(1, arr.minSetSize())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 9)
        assertEquals(1, arr.minSetSize())
    }

    @Test
    fun `simple test 4`() {
        val arr = intArrayOf(1000, 1000, 3, 7)
        assertEquals(1, arr.minSetSize())
    }

    @Test
    fun `simple test 5`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(5, arr.minSetSize())
    }

    @Test
    fun `simple test 6`() {
        val arr = intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)
        assertEquals(2, arr.minSetSize2())
    }

    @Test
    fun `simple test 7`() {
        val arr = intArrayOf(7, 7, 7, 7, 7, 7)
        assertEquals(1, arr.minSetSize2())
    }

    @Test
    fun `simple test 8`() {
        val arr = intArrayOf(1, 9)
        assertEquals(1, arr.minSetSize2())
    }

    @Test
    fun `simple test 9`() {
        val arr = intArrayOf(1000, 1000, 3, 7)
        assertEquals(1, arr.minSetSize2())
    }

    @Test
    fun `simple test 10`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(5, arr.minSetSize2())
    }
}
