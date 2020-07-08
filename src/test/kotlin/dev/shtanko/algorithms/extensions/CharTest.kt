package dev.shtanko.algorithms.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CharTest {
    @Test
    fun `simple test`() {
        val randomString = ('a'..'z').randomString(6)
        assertEquals(6, randomString.length)
    }

    @Test
    fun `simple test 2`() {
        val randomString = ('A'..'Z').randomString(6)
        assertEquals(6, randomString.length)
    }

    @Test
    fun `simple test 3`() {
        val randomString = ('A'..'Z').randomString(600)
        assertEquals(600, randomString.length)
    }
}
