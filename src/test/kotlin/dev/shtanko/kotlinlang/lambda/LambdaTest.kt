package dev.shtanko.kotlinlang.lambda

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LambdaTest {

    @Test
    fun `simple test`() {
        assertEquals(20, mul(10))
        assertEquals(6, mul(3))
    }
}
