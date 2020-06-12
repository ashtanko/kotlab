package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 1, 2)
        val actual = arr.removeDuplicates()
        assertEquals(2, actual)
    }

    @Test
    fun `no duplicates test`() {
        val arr = intArrayOf(4, 8, 15)
        val actual = arr.removeDuplicates()
        assertEquals(3, actual)
    }
}
