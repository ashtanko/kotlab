package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.Assert.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class HighFiveTest<out T : HighFiveStrategy>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 91),
                    intArrayOf(1, 92),
                    intArrayOf(2, 93),
                    intArrayOf(2, 97),
                    intArrayOf(1, 60),
                    intArrayOf(2, 77),
                    intArrayOf(1, 65),
                    intArrayOf(1, 87),
                    intArrayOf(1, 100),
                    intArrayOf(2, 100),
                    intArrayOf(2, 76)
                ),
                arrayOf(
                    intArrayOf(1, 87),
                    intArrayOf(2, 88)
                )
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(1, 100),
                    intArrayOf(7, 100),
                    intArrayOf(1, 100),
                    intArrayOf(7, 100),
                    intArrayOf(1, 100),
                    intArrayOf(7, 100),
                    intArrayOf(1, 100),
                    intArrayOf(7, 100),
                    intArrayOf(1, 100),
                    intArrayOf(7, 100)
                ),
                arrayOf(
                    intArrayOf(1, 100),
                    intArrayOf(7, 100)
                )
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `high five test`(items: Array<IntArray>, expected: Array<IntArray>) {
        val actual = strategy.perform(items)
        assertArrayEquals(expected, actual)
    }
}

internal class HighFivePriorityQueueTest : HighFiveTest<HighFivePriorityQueue>(HighFivePriorityQueue())
internal class HighFiveSortTest : HighFiveTest<HighFiveSort>(HighFiveSort())
