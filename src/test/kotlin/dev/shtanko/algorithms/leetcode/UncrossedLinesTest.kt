package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UncrossedLinesTest {

    @Test
    fun `simple test`() {
        val numbers = intArrayOf(1, 4, 2) to intArrayOf(1, 2, 4)
        assertEquals(2, numbers.maxUncrossedLines())
    }

    @Test
    fun `simple test 2`() {
        val numbers = intArrayOf(2, 5, 1, 2, 5) to intArrayOf(10, 5, 2, 1, 5, 2)
        assertEquals(3, numbers.maxUncrossedLines())
    }

    @Test
    fun `simple test 3`() {
        val numbers = intArrayOf(1, 3, 7, 1, 7, 5) to intArrayOf(1, 9, 2, 5, 1)
        assertEquals(2, numbers.maxUncrossedLines())
    }
}
