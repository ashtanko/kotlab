package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountLargestGroupTest {

    @Test
    fun `simple test`() {
        assertEquals(4, 13.countLargestGroup())
    }

    @Test
    fun `simple test 2`() {
        assertEquals(2, 2.countLargestGroup())
    }

    @Test
    fun `simple test 3`() {
        assertEquals(6, 15.countLargestGroup())
    }

    @Test
    fun `simple test 4`() {
        assertEquals(5, 24.countLargestGroup())
    }
}
