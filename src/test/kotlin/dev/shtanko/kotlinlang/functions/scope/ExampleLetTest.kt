package dev.shtanko.kotlinlang.functions.scope

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ExampleLetTest {

    @Test
    fun `let scope function test`() {
        val example = ExampleLet()
        example.printNonNull(null)
        example.printNonNull("a")
        assertTrue(example.isEmpty(""))
        assertFalse(example.isEmpty("a"))
    }
}
