package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class WaterBottlesTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(9, 3, 13),
            Arguments.of(15, 4, 19),
            Arguments.of(5, 5, 6),
            Arguments.of(2, 3, 2),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `num water bottles test`(numBottles: Int, numExchange: Int, expected: Int) {
        val actual = WaterBottles().perform(numBottles, numExchange)
        assertThat(actual, `is`(expected))
    }
}
