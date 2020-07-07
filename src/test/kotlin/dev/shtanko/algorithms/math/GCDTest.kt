package dev.shtanko.algorithms.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GCDTest {

    @Test
    fun `simple test`() {
        assertEquals(6, (54 to 24).gcd())
        assertEquals(14, (42 to 56).gcd())
    }
}
