package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NQueensIITest {

    @Test
    fun `simple test`() {
        assertEquals(2, 4.totalNQueens())
    }

    @Test
    fun `simple test 2`() {
        assertEquals(2, 4.totalNQueens2())
    }
}
