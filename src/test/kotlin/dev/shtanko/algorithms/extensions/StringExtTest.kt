package dev.shtanko.algorithms.extensions

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class StringExtTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("1", true),
            Arguments.of("0", true),
            Arguments.of("01", true),
            Arguments.of("A", false),
            Arguments.of("1A", false),
            Arguments.of("", false),
            Arguments.of(" ", false),
            Arguments.of(",", false),
            Arguments.of("a", false),
            Arguments.of("11111111111A", false),
            Arguments.of("111111111110000000", true)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `is binary test`(str: String, expected: Boolean) {
        val actual = str.isBinary()
        MatcherAssert.assertThat(actual, CoreMatchers.equalTo(expected))
    }
}
