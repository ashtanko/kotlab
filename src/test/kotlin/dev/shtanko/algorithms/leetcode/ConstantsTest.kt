package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstantsTest {
    @Test
    fun `simple test`() {
        assertEquals(10, DECIMAL)
        assertEquals(8, OCTAL)
        assertEquals(16, HEXADECIMAL)
        assertEquals(0xFFFF, SHUFFLE_CONST)
    }
}
