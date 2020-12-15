package dev.shtanko.datastructures

import org.hamcrest.CoreMatchers.equalTo
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

internal class ImmutableSetTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(3, 1, false),
            Arguments.of(3, 2, false),
            Arguments.of(3, 4, false),
            Arguments.of(3, 5, false),
            Arguments.of(3, 3, true),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `simple test`(n: Int, value: Int, expected: Boolean) {
        val actual = immutableSetOf(n).contains(value)
        assertThat(actual, equalTo(expected))
    }

    @Test
    internal fun `simple test 2`() {
        val set = immutableSetOf(*(10 downTo 1).toList().toTypedArray())
        for (v in set) {
            assertTrue(set.contains(v))
        }
        assertEquals(10, set.size)
        assertFalse(set.isEmpty())
        assertFalse(set.contains(42))
        assertFalse(set.contains(-42))
    }

    @Test
    internal fun `simple test 3`() {
        val set = immutableSetOf(*(0..100).toList().toTypedArray())
        for (v in -100..-1) {
            assertFalse(set.contains(v))
        }
        for (v in 0..100) {
            assertTrue(set.contains(v))
        }
        for (v in 101..200) {
            assertFalse(set.contains(v))
        }
    }
}
