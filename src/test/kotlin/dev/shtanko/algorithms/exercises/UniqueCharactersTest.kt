package dev.shtanko.algorithms.exercises

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class UniqueCharactersTest<out T : UniqueCharacters>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "",
                false
            ),
            Arguments.of(
                "a",
                true
            ),
            Arguments.of(
                "abc",
                true
            ),
            Arguments.of(
                "aab",
                false
            ),
            Arguments.of(
                "abcda",
                false
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `find unique characters test`(str: String, expected: Boolean) {
        val actual = strategy.perform(str)
        assertEquals(expected, actual)
    }
}

class UniqueCharactersSetTest : UniqueCharactersTest<UniqueCharactersSet>(UniqueCharactersSet())
class UniqueCharactersSortTest :
    UniqueCharactersTest<UniqueCharactersSort>(UniqueCharactersSort())

class UniqueCharactersStreamTest :
    UniqueCharactersTest<UniqueCharactersStream>(UniqueCharactersStream())

class UniqueCharactersBruteForceTest :
    UniqueCharactersTest<UniqueCharactersBruteForce>(UniqueCharactersBruteForce())
