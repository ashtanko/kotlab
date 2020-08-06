package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DIStringMatchTest {

    @Test
    fun `simple test`() {
        assertArrayEquals(intArrayOf(0, 4, 1, 3, 2), "IDID".diStringMatch())
    }

    @Test
    fun `simple test 2`() {
        assertArrayEquals(intArrayOf(0, 1, 2, 3), "III".diStringMatch())
    }

    @Test
    fun `simple test 3`() {
        assertArrayEquals(intArrayOf(3, 2, 0, 1), "DDI".diStringMatch())
    }
}
