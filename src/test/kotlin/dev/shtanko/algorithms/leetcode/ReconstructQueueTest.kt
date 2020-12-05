package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class ReconstructQueueTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 0),
                    intArrayOf(4, 4),
                    intArrayOf(7, 1),
                    intArrayOf(5, 0),
                    intArrayOf(6, 1),
                    intArrayOf(5, 2)
                ),
                arrayOf(
                    intArrayOf(5, 0),
                    intArrayOf(7, 0),
                    intArrayOf(5, 2),
                    intArrayOf(6, 1),
                    intArrayOf(4, 4),
                    intArrayOf(7, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `reconstruct queue test`(people: Array<IntArray>, expected: Array<IntArray>) {
        val actual = reconstructQueue(people)
        assertArrayEquals(expected, actual)
    }
}
