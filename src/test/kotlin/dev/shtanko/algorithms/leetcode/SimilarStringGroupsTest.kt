package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class SimilarStringGroupsTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf(""), 1),
            Arguments.of(arrayOf("a"), 1),
            Arguments.of(arrayOf("a", "aa", "a"), 3),
            Arguments.of(arrayOf("one"), 1),
            Arguments.of(arrayOf("tars", "rats", "arts", "star"), 2),
            Arguments.of(arrayOf("omv", "ovm"), 1)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `num similar groups test`(strings: Array<String>, expected: Int) {
        val actual = SimilarStringGroups().perform(strings)
        assertEquals(expected, actual)
    }
}
