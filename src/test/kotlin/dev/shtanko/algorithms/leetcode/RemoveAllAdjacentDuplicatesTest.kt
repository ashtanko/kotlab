package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class RemoveAllAdjacentDuplicatesTest<out T : RemoveAllAdjacentDuplicatesStrategy>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("abbaca", "ca"),
            Arguments.of("abbacddc", ""),
            Arguments.of("", ""),
            Arguments.of("12213", "3"),
            Arguments.of("$##%", "$%")
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `remove all adjacent duplicates in string test`(s: String, expected: String) {
        val actual = strategy.perform(s)
        assertEquals(expected, actual)
    }
}

internal class RemoveAllAdjacentDuplicatesArrayTest :
    RemoveAllAdjacentDuplicatesTest<RemoveAllAdjacentDuplicatesArray>(RemoveAllAdjacentDuplicatesArray())

internal class RemoveAllAdjacentDuplicatesStackTest :
    RemoveAllAdjacentDuplicatesTest<RemoveAllAdjacentDuplicatesStack>(RemoveAllAdjacentDuplicatesStack())

// Using StringBuilder
internal class RemoveAllAdjacentDuplicatesSBTest :
    RemoveAllAdjacentDuplicatesTest<RemoveAllAdjacentDuplicatesSB>(RemoveAllAdjacentDuplicatesSB())
