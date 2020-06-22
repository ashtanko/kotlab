package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WildcardMatchingTest {

    @Test
    fun `simple test`() {
        assertFalse(("aa" to "a").isMatch())
    }

    @Test
    fun `simple test 2`() {
        assertTrue(("aa" to "*").isMatch())
    }

    @Test
    fun `simple test 3`() {
        assertFalse(("cb" to "?a").isMatch())
    }

    @Test
    fun `simple test 4`() {
        assertTrue(("adceb" to "*a*b").isMatch())
    }

    @Test
    fun `simple test 5`() {
        assertFalse(("acdcb" to "a*c?b").isMatch())
    }
}
