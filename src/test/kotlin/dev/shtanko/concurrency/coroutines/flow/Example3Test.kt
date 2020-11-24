package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Example3Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `foo test`() = runBlockingTest {
        assertEquals(listOf(1, 2, 3), example3Foo())
    }
}
