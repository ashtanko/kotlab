package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddDigitsTest {

    @Test
    fun `simple test`() {
        assertEquals(2, 38.addDigits())
    }

    @Test
    fun `simple test 2`() {
        assertEquals(2, 38.addDigitsMath())
    }
}
