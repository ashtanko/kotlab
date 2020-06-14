package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringToIntegerTest {

    @Test
    fun `empty string to int test`() {
        val str = ""
        val actual = str.atoi()
        assertEquals(0, actual)
    }

    @Test
    fun `zero number string to int test`() {
        val str = "0"
        val actual = str.atoi()
        assertEquals(0, actual)
    }

    @Test
    fun `positive number string to int test`() {
        val str = "4"
        val actual = str.atoi()
        assertEquals(4, actual)
    }
}
