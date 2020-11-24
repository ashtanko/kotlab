package dev.shtanko.concurrency.coroutines.flow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Example1Test {

    @Test
    fun `foo test`() {
        assertEquals(listOf(1, 2, 3), example1Foo())
    }
}
