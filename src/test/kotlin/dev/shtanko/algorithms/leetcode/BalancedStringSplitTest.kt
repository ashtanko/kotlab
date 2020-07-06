package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BalancedStringSplitTest {

    @Test
    fun `simple test`() {
        val str = "RLRRLLRLRL"
        val actual = str.balancedStringSplit()
        assertEquals(4, actual)
    }

    @Test
    fun `simple test 2`() {
        val str = "RLLLLRRRLR"
        val actual = str.balancedStringSplit()
        assertEquals(3, actual)
    }

    @Test
    fun `simple test 3`() {
        val str = "LLLLRRRR"
        val actual = str.balancedStringSplit()
        assertEquals(1, actual)
    }

    @Test
    fun `simple test 4`() {
        val str = "RLRRRLLRLL"
        val actual = str.balancedStringSplit()
        assertEquals(2, actual)
    }
}
