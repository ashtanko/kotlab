package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RobotReturnToOriginTest {

    @Test
    fun `simple test`() {
        val moves = "UD"
        assertTrue(judgeCircle(moves))
    }

    @Test
    fun `simple test 2`() {
        val moves = "LL"
        assertFalse(judgeCircle(moves))
    }
}
