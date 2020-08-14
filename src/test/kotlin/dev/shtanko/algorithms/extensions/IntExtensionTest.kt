package dev.shtanko.algorithms.extensions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IntExtensionTest {

    @Test
    fun `is even test`() {
        assertTrue(4.isEven)
        assertFalse(3.isEven)
    }

    @Test
    fun `random array test`() {
        assertEquals(3, 3.generateRandomArray().size)
    }
}
