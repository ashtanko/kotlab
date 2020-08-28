package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ToLowerCaseTest {

    @Test
    fun `simple test`() {
        assertEquals("hello", toLowerCase("Hello"))
    }

    @Test
    fun `simple test 2`() {
        assertEquals("here", toLowerCase("here"))
    }

    @Test
    fun `simple test 3`() {
        assertEquals("lovely", toLowerCase("LOVELY"))
    }
}
