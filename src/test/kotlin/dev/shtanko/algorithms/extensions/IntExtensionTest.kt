package dev.shtanko.algorithms.extensions

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class IntExtensionTest {

    internal class InputIsEvenArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(2, true),
            Arguments.of(3, false),
            Arguments.of(4, true),
            Arguments.of(6, true),
            Arguments.of(8, true),
            Arguments.of(9, false),
            Arguments.of(11, false),
            Arguments.of(100, true),
            Arguments.of(Int.MAX_VALUE, false),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputIsEvenArgumentsProvider::class)
    internal fun `is even test`(n: Int, expected: Boolean) {
        val actual = n.isEven
        assertThat(actual, `is`(expected))
    }

    @ParameterizedTest
    @ArgumentsSource(InputIsEvenArgumentsProvider::class)
    internal fun `is even fun interface test`(n: Int, expected: Boolean) {
        val actual = isEven.accept(n)
        assertThat(actual, `is`(expected))
    }

    @Test
    internal fun `random array test`() {
        assertEquals(3, 3.generateRandomArray().size)
    }

    @Test
    internal fun `less than zero test`() {
        assertTrue((-1).lessThanZero())
    }

    @Test
    internal fun `more than zero test`() {
        assertFalse(1.lessThanZero())
    }
}
