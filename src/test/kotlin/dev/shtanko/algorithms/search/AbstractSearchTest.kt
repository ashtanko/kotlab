package dev.shtanko.algorithms.search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

@Suppress("ArrayPrimitive")
internal abstract class AbstractSearchTest<out T : AbstractSearchStrategy<Int>>(private val strategy: T) {

    private class InputIntArrayArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf<Int>(), 1, -1),
            Arguments.of(arrayOf(1), 1, 0),
            Arguments.of(arrayOf(1), 2, -1),
            Arguments.of(arrayOf(4, 8), 4, 0),
            Arguments.of(arrayOf(4, 8), 8, 1),
            Arguments.of(arrayOf(4, 8), 9, -1),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 4, 0),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 8, 1),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 15, 2),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 16, 3),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 23, 4),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 42, 5),
            Arguments.of(arrayOf(4, 8, 15, 16, 23, 42), 43, -1)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputIntArrayArgumentsProvider::class)
    internal fun `int array test`(arr: Array<Int>, element: Int, expected: Int) {
        val actual = strategy.perform(arr, element)
        assertEquals(expected, actual)
    }
}
