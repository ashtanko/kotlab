package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveElementTest {

    @Test
    fun `no element test`() {
        val arr = intArrayOf(2, 3, 3, 2)
        val size = arr.removeElement(4)
        assertEquals(arr.size, size)
    }

    @Test
    fun `simple test`() {
        val arr = intArrayOf(2, 3, 3, 2)
        val size = arr.removeElement(2)
        assertEquals(2, size)
    }

    @Test
    fun `example 2 test`() {
        val arr = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val size = arr.removeElement(2)
        assertEquals(5, size)
    }
}
