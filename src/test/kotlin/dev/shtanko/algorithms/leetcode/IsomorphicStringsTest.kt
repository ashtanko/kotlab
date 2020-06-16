package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsomorphicStringsTest {

    @Test
    fun `simple test`() {
        val pair = "egg" to "add"
        assertTrue(pair.isIsomorphic())
    }

    @Test
    fun `simple test 1`() {
        val pair = "foo" to "bar"
        assertFalse(pair.isIsomorphic())
    }

    @Test
    fun `simple test 2`() {
        val pair = "paper" to "title"
        assertTrue(pair.isIsomorphic())
    }
}
