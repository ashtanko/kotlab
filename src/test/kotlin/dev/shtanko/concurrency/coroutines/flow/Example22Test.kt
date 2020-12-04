package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
class Example22Test {

    @Test
    fun `nums test`() = runBlockingTest {
        val nums = Example22.getNums().toList()
        assertEquals(listOf(1, 2, 3), nums)
    }

    @Test
    fun `strings test`() = runBlockingTest {
        val actual = Example22.getStrings().toList()
        assertEquals(listOf("one", "two", "three"), actual)
    }

    @Test
    fun `perform test`() = runBlockingTest {
        Example22.perform()
    }
}
