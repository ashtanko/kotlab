package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Example12Test {
    @ExperimentalCoroutinesApi
    @Test
    fun `filter test`() = runBlockingTest {
        assertEquals(listOf("string 2", "string 4"), getData12(5).toList())
    }
}
