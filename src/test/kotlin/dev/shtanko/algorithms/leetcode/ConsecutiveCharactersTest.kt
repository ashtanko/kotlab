package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConsecutiveCharactersTest {

    @Test
    fun `simple test`() {
        val s = "leetcode"
        assertEquals(2, s.maxPower())
    }

    @Test
    fun `simple test 2`() {
        val s = "abbcccddddeeeeedcba"
        assertEquals(5, s.maxPower())
    }

    @Test
    fun `simple test 3`() {
        val s = "triplepillooooow"
        assertEquals(5, s.maxPower())
    }

    @Test
    fun `simple test 4`() {
        val s = "hooraaaaaaaaaaay"
        assertEquals(11, s.maxPower())
    }

    @Test
    fun `simple test 5`() {
        val s = "tourist"
        assertEquals(1, s.maxPower())
    }

    @Test
    fun `empty test`() {
        val s = ""
        assertEquals(0, s.maxPower())
    }

    @Test
    fun `onr letter test`() {
        val s = "a"
        assertEquals(1, s.maxPower())
    }

    @Test
    fun `simple test 6`() {
        val s = "leetcode"
        assertEquals(2, s.maxPower2())
    }

    @Test
    fun `simple test 7`() {
        val s = "abbcccddddeeeeedcba"
        assertEquals(5, s.maxPower2())
    }

    @Test
    fun `simple test 8`() {
        val s = "triplepillooooow"
        assertEquals(5, s.maxPower2())
    }

    @Test
    fun `simple test 9`() {
        val s = "hooraaaaaaaaaaay"
        assertEquals(11, s.maxPower2())
    }

    @Test
    fun `simple test 10`() {
        val s = "tourist"
        assertEquals(1, s.maxPower2())
    }

    @Test
    fun `empty test 2`() {
        val s = ""
        assertEquals(0, s.maxPower2())
    }

    @Test
    fun `onr letter test 2`() {
        val s = "a"
        assertEquals(1, s.maxPower2())
    }
}
