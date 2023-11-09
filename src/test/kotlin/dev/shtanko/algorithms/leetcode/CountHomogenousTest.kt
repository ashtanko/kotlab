package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class CountHomogenousTest<out T : CountHomogenous>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "abbcccaa",
                13,
            ),
            Arguments.of(
                "xy",
                2,
            ),
            Arguments.of(
                "zzzzz",
                15,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `count homogenous test`(s: String, expected: Int) {
        val actual = strategy(s)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class CountHomogenousCountingStreaksTest : CountHomogenousTest<CountHomogenous>(CountHomogenousCountingStreaks())
