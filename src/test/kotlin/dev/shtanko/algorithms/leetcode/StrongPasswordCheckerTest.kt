package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrongPasswordCheckerTest {

    @Test
    fun `simple test`() {
        val actual = strongPasswordChecker("")
        val expected = 6
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val actual = strongPasswordChecker("123456")
        val expected = 2
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val actual = strongPasswordChecker("qwerty")
        val expected = 2
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val actual = strongPasswordChecker("password123456")
        val expected = 1
        assertEquals(expected, actual)
    }
}
