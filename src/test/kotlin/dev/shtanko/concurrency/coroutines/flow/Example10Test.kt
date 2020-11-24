package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Example10Test {
    @ExperimentalCoroutinesApi
    @Test
    fun `numbers test`() = runBlockingTest {
        assertEquals(listOf(1, 2), numbers().take(2).toList())
    }
}
