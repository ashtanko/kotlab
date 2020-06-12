package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BuddyStringsTest {

    @Test
    fun `simple test`() {
        val pair = "ab" to "ba"
        val actual = pair.buddyStrings()
        assertTrue(actual)
    }

    @Test
    fun `simple test 2`() {
        val pair = "ab" to "ab"
        val actual = pair.buddyStrings()
        assertFalse(actual)
    }

    @Test
    fun `simple test 3`() {
        val pair = "aa" to "aa"
        val actual = pair.buddyStrings()
        assertTrue(actual)
    }

    @Test
    fun `simple test 4`() {
        val pair = "aaaaaaabc" to "aaaaaaacb"
        val actual = pair.buddyStrings()
        assertTrue(actual)
    }

    @Test
    fun `simple test 5`() {
        val pair = "" to "aa"
        val actual = pair.buddyStrings()
        assertFalse(actual)
    }
}
