package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class XOROperationTest {

    @Test
    fun `simple test`() {
        assertEquals(8, 5.xorOperation(0))
    }

    @Test
    fun `simple test 2`() {
        assertEquals(8, 4.xorOperation(3))
    }

    @Test
    fun `simple test 3`() {
        assertEquals(7, 1.xorOperation(7))
    }

    @Test
    fun `simple test 4`() {
        assertEquals(2, 10.xorOperation(5))
    }
}
