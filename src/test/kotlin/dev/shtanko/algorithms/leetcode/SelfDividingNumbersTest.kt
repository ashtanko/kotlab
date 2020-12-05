package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class SelfDividingNumbersTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                1 to 22,
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `self dividing numbers test`(numbers: Pair<Int, Int>, expected: List<Int>) {
        val actual = numbers.selfDividingNumbers()
        assertEquals(expected, actual)
    }
}
