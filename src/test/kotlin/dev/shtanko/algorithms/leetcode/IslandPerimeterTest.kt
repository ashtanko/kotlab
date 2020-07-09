package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IslandPerimeterTest {

    @Test
    fun `simple test`() {
        val arr = arrayOf(
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 0, 0)
        )
        assertEquals(16, arr.islandPerimeter())
    }
}
