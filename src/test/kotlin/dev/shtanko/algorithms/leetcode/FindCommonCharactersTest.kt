package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.randomString
import dev.shtanko.util.assertListEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindCommonCharactersTest {

    @Test
    fun `simple test`() {
        val arr = arrayOf("bella", "label", "roller")
        val actual = arr.commonChars()
        val expected = listOf("e", "l", "l")
        assertTrue(assertListEquals(expected, actual))
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val arr = arrayOf("cool", "lock", "cook")
        val actual = arr.commonChars()
        val expected = listOf("c", "o")
        assertTrue(assertListEquals(expected, actual))
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val arr = arrayOf("a", "b", "c")
        val actual = arr.commonChars()
        assertTrue(actual.isEmpty())
    }

    @Test
    fun `simple test 4`() {
        val arr = arrayOf("far", "bar", "rar")
        val actual = arr.commonChars()
        val expected = listOf("a", "r")
        assertTrue(assertListEquals(expected, actual))
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 5`() {
        val array = Array(100_000) { ('a'..'z').randomString(6) + "q" }
        val actual = array.commonChars()
        val expected = listOf("q")
        assertTrue(assertListEquals(expected, actual))
        assertEquals(expected, actual)
    }
}
