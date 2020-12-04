package dev.shtanko.algorithms.search

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class AbstractStringSearchTest<out T : AbstractSearchStrategy<String>>(private val strategy: T) {

    private class InputStringArrayArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf<String>(), "A", -1),
            Arguments.of(arrayOf("A"), "A", 0),
            Arguments.of(arrayOf("A"), "B", -1),
            Arguments.of(arrayOf("A", "B"), "A", 0),
            Arguments.of(arrayOf("A", "B"), "B", 1),
            Arguments.of(arrayOf("A", "B"), "C", -1)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputStringArrayArgumentsProvider::class)
    fun `string array test`(arr: Array<String>, element: String, expected: Int) {
        val actual = strategy.perform(arr, element)
        assertEquals(expected, actual)
    }
}
