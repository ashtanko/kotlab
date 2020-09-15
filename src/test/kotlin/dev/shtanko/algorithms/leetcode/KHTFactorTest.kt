package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KHTFactorTest {

    @Test
    fun `simple test`() {
        val n = 12
        val k = 3
        assertEquals(3, kthFactor(n, k))
    }

    @Test
    fun `simple test 2`() {
        val n = 7
        val k = 2
        assertEquals(7, kthFactor(n, k))
    }

    @Test
    fun `simple test 3`() {
        val n = 4
        val k = 4
        assertEquals(-1, kthFactor(n, k))
    }

    @Test
    fun `simple test 4`() {
        val n = 1
        val k = 1
        assertEquals(1, kthFactor(n, k))
    }

    @Test
    fun `simple test 5`() {
        val n = 1000
        val k = 3
        assertEquals(4, kthFactor(n, k))
    }
}
