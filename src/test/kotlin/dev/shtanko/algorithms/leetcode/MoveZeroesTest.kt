package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MoveZeroesTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(0, 1, 0, 3, 12)
        arr.moveZeroes()
        assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), arr)
    }
}
