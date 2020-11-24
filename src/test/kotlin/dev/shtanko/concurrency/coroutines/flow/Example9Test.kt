package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Example9Test {
    @ExperimentalCoroutinesApi
    @Test
    fun `perform request test`() = runBlockingTest {
        assertEquals("response 1", performRequest9(1))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `perform test`() = runBlockingTest {
        assertEquals(
            listOf(
                "Making request 1",
                "response 1",
                "Making request 2",
                "response 2",
                "Making request 3",
                "response 3"
            ), getData9().toList()
        )
    }
}
