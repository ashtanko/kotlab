package dev.shtanko.algorithms.extensions

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class CharTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of('a'..'z', 0, 0),
            Arguments.of('a'..'z', 6, 6),
            Arguments.of('A'..'Z', 6, 6),
            Arguments.of('A'..'Z', 600, 600),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `random string test`(range: CharRange, len: Int, expected: Int) {
        val randomString = range.randomString(len)
        val actual = randomString.length
        assertThat(actual, equalTo(expected))
    }
}
