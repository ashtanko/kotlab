package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumTeamsTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(2, 5, 3, 4, 1)
        assertEquals(3, arr.numTeams())
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(2, 1, 3)
        assertEquals(0, arr.numTeams())
    }

    @Test
    fun `simple test 3`() {
        val arr = intArrayOf(1, 2, 3, 4)
        assertEquals(4, arr.numTeams())
    }
}
