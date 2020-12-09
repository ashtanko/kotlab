package dev.shtanko.algorithms.exercises

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class BinaryToDecimalTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("1", 1),
            Arguments.of("10", 2),
            Arguments.of("11", 3),
            Arguments.of("1010", 10),
            Arguments.of("1101011000010", 6850),
            Arguments.of("10011011001110", 9934)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `binary to decimal test`(binary: String, expected: Int) {
        val actual = BinaryToDecimal().perform(binary)
        MatcherAssert.assertThat(actual, CoreMatchers.equalTo(expected))
    }
}
