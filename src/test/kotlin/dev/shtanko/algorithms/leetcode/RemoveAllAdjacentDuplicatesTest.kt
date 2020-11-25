package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class RemoveAllAdjacentDuplicatesTest<out T : RemoveAllAdjacentDuplicatesStrategy>(private val strategy: T) {

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
    fun `remove all adjacent duplicates in string test`(s: String, expected: String) {
        val actual = strategy.perform(s)
        assertEquals(expected, actual)
    }
}

class RemoveAllAdjacentDuplicatesArrayTest :
    RemoveAllAdjacentDuplicatesTest<RemoveAllAdjacentDuplicatesArray>(RemoveAllAdjacentDuplicatesArray())

class RemoveAllAdjacentDuplicatesStackTest :
    RemoveAllAdjacentDuplicatesTest<RemoveAllAdjacentDuplicatesStack>(RemoveAllAdjacentDuplicatesStack())

// Using StringBuilder
class RemoveAllAdjacentDuplicatesSBTest :
    RemoveAllAdjacentDuplicatesTest<RemoveAllAdjacentDuplicatesSB>(RemoveAllAdjacentDuplicatesSB())
