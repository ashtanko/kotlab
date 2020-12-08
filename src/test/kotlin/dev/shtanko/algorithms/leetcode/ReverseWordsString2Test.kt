package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ReverseWordsString2Test {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                charArrayOf('t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'),
                charArrayOf('b', 'l', 'u', 'e', ' ', 'i', 's', ' ', 's', 'k', 'y', ' ', 't', 'h', 'e')
            )
        )
    }

    internal class InputToReverseArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                charArrayOf(),
                0,
                0,
                charArrayOf()
            ),
            Arguments.of(
                charArrayOf('t', 'h', 'e'),
                0,
                2,
                charArrayOf('e', 'h', 't')
            )
        )
    }

    internal class InputToReverseWordArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                charArrayOf(),
                charArrayOf()
            ),
            Arguments.of(
                charArrayOf('t', 'h', 'e'),
                charArrayOf('e', 'h', 't')
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `internal test`(s: CharArray, expected: CharArray) {
        ReverseWordsInString2().perform(s)
        assertArrayEquals(expected, s)
    }

    @ParameterizedTest
    @ArgumentsSource(InputToReverseArgumentsProvider::class)
    internal fun `reverse whole string test`(s: CharArray, left: Int, right: Int, expected: CharArray) {
        ReverseWordsInString2().reverse(s, left, right)
        assertArrayEquals(expected, s)
    }

    @ParameterizedTest
    @ArgumentsSource(InputToReverseWordArgumentsProvider::class)
    internal fun `reverse each word test`(s: CharArray, expected: CharArray) {
        ReverseWordsInString2().reverseEachWord(s)
        assertArrayEquals(expected, s)
    }
}
