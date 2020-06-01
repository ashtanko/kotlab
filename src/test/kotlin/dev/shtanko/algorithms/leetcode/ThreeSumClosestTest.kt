package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSumClosestTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(-1, 2, 1, -4)
        val target = 1
        val result = arr.threeSumClosest(target)
        assertEquals(2, result)
    }
}