package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class ThreeSumSmallerTest<out T : ThreeSumSmallerStrategy>(val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(-2, 0, 1, 3),
                2,
                2
            ),
            Arguments.of(
                intArrayOf(),
                0,
                0
            ),
            Arguments.of(
                intArrayOf(0),
                0,
                0
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `3 sum test`(nums: IntArray, target: Int, expected: Int) {
        val actual = strategy.perform(nums, target)
        assertEquals(expected, actual)
    }
}

internal class ThreeSumSmallerBinarySearchTest :
    ThreeSumSmallerTest<ThreeSumSmallerBinarySearch>(ThreeSumSmallerBinarySearch())

internal class ThreeSumSmallerTwoPointersTest :
    ThreeSumSmallerTest<ThreeSumSmallerTwoPointers>(ThreeSumSmallerTwoPointers())
