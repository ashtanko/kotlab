package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class SumEvenAfterQueriesTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4),
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(-3, 1),
                    intArrayOf(-4, 0),
                    intArrayOf(2, 3)
                ),
                intArrayOf(8, 6, 2, 4)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `sum even after queries test`(a: IntArray, queries: Array<IntArray>, expected: IntArray) {
        val actual = sumEvenAfterQueries(a, queries)
        assertArrayEquals(expected, actual)
    }
}
