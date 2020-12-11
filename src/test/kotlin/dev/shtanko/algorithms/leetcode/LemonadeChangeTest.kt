package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class LemonadeChangeTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(0), false),
            Arguments.of(intArrayOf(5, 5, 5, 10, 20), true),
            Arguments.of(intArrayOf(5, 5, 10), true),
            Arguments.of(intArrayOf(10, 10), false),
            Arguments.of(intArrayOf(5, 5, 10, 10, 20), false),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `lemonade change test`(bills: IntArray, expected: Boolean) {
        val actual = LemonadeChange().perform(bills)
        assertThat(actual, `is`(expected))
    }
}
