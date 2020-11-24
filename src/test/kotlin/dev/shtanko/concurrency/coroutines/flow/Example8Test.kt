package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Example8Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `perform request test`() = runBlockingTest {
        assertEquals("response 1", performRequestExample8(1))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `perform test`() = runBlockingTest {
        assertEquals(listOf("response 1", "response 2", "response 3"), getExample8Data().toList())
    }
}
