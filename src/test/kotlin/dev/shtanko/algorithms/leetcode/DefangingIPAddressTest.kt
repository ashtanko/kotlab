package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DefangingIPAddressTest {

    @Test
    fun `simple test`() {
        val address = "1.1.1.1"
        val expected = "1[.]1[.]1[.]1"
        val actual = address.defangIPaddrNaive()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val address = "255.100.50.0"
        val expected = "255[.]100[.]50[.]0"
        val actual = address.defangIPaddrNaive()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val address = "1.1.1.1"
        val expected = "1[.]1[.]1[.]1"
        val actual = address.defangIPaddr()
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val address = "255.100.50.0"
        val expected = "255[.]100[.]50[.]0"
        val actual = address.defangIPaddr()
        assertEquals(expected, actual)
    }
}
