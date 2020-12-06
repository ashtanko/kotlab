package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class WiggleSortTest<out T : WiggleSort>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 5, 2, 1, 6, 4),
                intArrayOf(3, 5, 1, 6, 2, 4)
            ),
            Arguments.of(
                intArrayOf(),
                intArrayOf()
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `wiggle sort test`(nums: IntArray, expected: IntArray) {
        strategy.perform(nums)
        assertArrayEquals(expected, nums)
    }
}

internal class WiggleSortOnePassSwapTest : WiggleSortTest<WiggleSortOnePassSwap>(WiggleSortOnePassSwap())
