package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DivisorGameTest {

    @Test
    fun `simple test`() {
        assertTrue(2.divisorGame())
    }

    @Test
    fun `simple test 2`() {
        assertFalse(3.divisorGame())
    }

    @Test
    fun `simple test 3`() {
        assertTrue(48.divisorGame())
    }

    @Test
    fun `simple test 4`() {
        assertFalse(Int.MAX_VALUE.divisorGame())
    }

    @Test
    fun `simple test 5`() {
        assertTrue(2.divisorGameNaive())
    }

    @Test
    fun `simple test 6`() {
        assertFalse(3.divisorGameNaive())
    }

    @Test
    fun `simple test 7`() {
        assertTrue(48.divisorGameBruteForce())
    }

    @Test
    fun `simple test 8`() {
        assertFalse(Int.MAX_VALUE.divisorGameBruteForce())
    }

    @Test
    fun `simple test 9`() {
        assertTrue(2.divisorGameBruteForce())
    }

    @Test
    fun `simple test 10`() {
        assertFalse(3.divisorGameBruteForce())
    }

    @Test
    fun `simple test 11`() {
        assertTrue(48.divisorGameBruteForce())
    }

    @Test
    fun `simple test 12`() {
        assertFalse(Int.MAX_VALUE.divisorGameBruteForce())
    }
}
