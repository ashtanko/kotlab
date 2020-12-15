package dev.shtanko.kotlinlang.lambda

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LambdaTest {

    @Test
    internal fun `simple test`() {
        assertEquals(20, mul(10))
        assertEquals(6, mul(3))
    }

    @Test
    internal fun `given list of number when doing operations using lambda should return proper result`() {
        // given
        val listOfNumbers = listOf(1, 2, 3)

        // when
        val sum = listOfNumbers.reduce { a, b -> a + b }

        // then
        assertEquals(6, sum)
    }
}
