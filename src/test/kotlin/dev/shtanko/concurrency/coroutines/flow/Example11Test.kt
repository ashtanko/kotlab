package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Example11Test {
    @ExperimentalCoroutinesApi
    @Test
    fun `reduce test`() = runBlockingTest {
        assertEquals(55, getData11(5))
    }
}
