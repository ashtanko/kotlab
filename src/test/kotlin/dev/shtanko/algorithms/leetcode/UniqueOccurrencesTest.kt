package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UniqueOccurrencesTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 2, 1, 1, 3)
        assertTrue(arr.uniqueOccurrences())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(1, 2)
        assertFalse(arr.uniqueOccurrences())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)
        assertTrue(arr.uniqueOccurrences())
    }
}
