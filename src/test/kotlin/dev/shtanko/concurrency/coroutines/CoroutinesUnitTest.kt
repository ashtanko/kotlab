package dev.shtanko.concurrency.coroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

class CoroutinesUnitTest {
    @ExperimentalCoroutinesApi
    @Test
    fun `test foo`() = runBlockingTest { // a coroutine with an extra test control
        // TODO val actual = foo()
    }

    private suspend fun foo() {
        delay(1_000) // auto-advances virtual time by 1_000ms due to runBlockingTest
    }
}
