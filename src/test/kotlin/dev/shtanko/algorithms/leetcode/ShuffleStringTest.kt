package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShuffleStringTest {

    @Test
    fun `simple test`() {
        val s = "codeleet"
        val indices = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
        val expected = "leetcode"
        val actual = (s to indices).restoreString()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val s = "abc"
        val indices = intArrayOf(0, 1, 2)
        val expected = "abc"
        val actual = (s to indices).restoreString()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val s = "aiohn"
        val indices = intArrayOf(3, 1, 4, 2, 0)
        val expected = "nihao"
        val actual = (s to indices).restoreString()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val s = "aaiougrt"
        val indices = intArrayOf(4, 0, 2, 6, 7, 3, 1, 5)
        val expected = "arigatou"
        val actual = (s to indices).restoreString()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 5`() {
        val s = "art"
        val indices = intArrayOf(1, 0, 2)
        val expected = "rat"
        val actual = (s to indices).restoreString()
        assertEquals(expected, actual)
    }
}
