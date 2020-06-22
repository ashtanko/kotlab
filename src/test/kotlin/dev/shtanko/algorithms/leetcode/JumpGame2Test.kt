package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGame2Test {

    @Test
    fun `simple test`() {
        assertEquals(2, intArrayOf(2, 3, 1, 1, 4).jump())
    }
}
