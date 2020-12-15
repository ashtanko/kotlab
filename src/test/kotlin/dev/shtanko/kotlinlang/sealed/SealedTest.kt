package dev.shtanko.kotlinlang.sealed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

internal class SealedTest {

    @Test
    internal fun `test success`() {
        val result = divide(10, 5)
        assertEquals(Success<Float, String>(2.0f), result)
    }

    @Test
    internal fun `test error`() {
        val result = divide(10, 0)
        assertEquals(Failure<Float, String>("Division by zero"), result)
    }

    @Test
    internal fun `test match on success`() {
        when (divide(10, 5)) {
            is Success -> {
                // Expected
            }
            is Failure -> fail("Expected Success")
        }
    }

    @Test
    internal fun `test match on error`() {
        when (divide(10, 0)) {
            is Failure -> {
                // Expected
            }
            else -> {
            }
        }
    }

    @Test
    internal fun `test get success`() {
        val result = divide(10, 5)
        assertEquals(2.0f, result.get())
    }

    @Test
    internal fun `test get error`() {
        val result = divide(10, 0)
        assertNull(result.get())
    }

    @Test
    internal fun `test map on success`() {
        val result = divide(10, 5)
            .map { "Result: $it" }
        assertEquals(Success<String, String>("Result: 2.0"), result)
    }

    @Test
    internal fun `test map on error`() {
        val result = divide(10, 0)
            .map { "Result: $it" }
        assertEquals(Failure<Float, String>("Division by zero"), result)
    }

    @Test
    internal fun `test map failure on success`() {
        val result = divide(10, 5)
            .mapFailure { "Failure: $it" }
        assertEquals(Success<Float, String>(2.0f), result)
    }

    @Test
    internal fun `test map failure on error`() {
        val result = divide(10, 0)
            .mapFailure { "Failure: $it" }
        assertEquals(Failure<Float, String>("Failure: Division by zero"), result)
    }

    private fun divide(a: Int, b: Int): Result<Float, String> = when (b) {
        0 -> Failure("Division by zero")
        else -> Success(a.toFloat() / b)
    }
}
