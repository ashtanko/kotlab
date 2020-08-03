package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReformatTheStringTest {

    @Test
    fun `simple test`() {
        assertEquals("a0b1c2", "a0b1c2".reformat())
    }

    @Test
    fun `simple test 2`() {
        assertEquals("", "leetcode".reformat())
    }

    @Test
    fun `simple test 3`() {
        assertEquals("", "1229857369".reformat())
    }

    @Test
    fun `simple test 4`() {
        assertEquals("c2o0v1i9d", "covid2019".reformat())
    }

    @Test
    fun `simple test 5`() {
        assertEquals("1a2b3", "ab123".reformat())
    }
}
