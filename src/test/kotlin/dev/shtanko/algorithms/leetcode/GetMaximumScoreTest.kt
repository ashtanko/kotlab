package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class GetMaximumScoreTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 4, 5, 8, 10),
                intArrayOf(4, 6, 8, 9),
                30
            ),
            Arguments.of(
                intArrayOf(1, 3, 5, 7, 9),
                intArrayOf(3, 5, 100),
                109
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `get the maximum score test`(nums1: IntArray, nums2: IntArray, expected: Int) {
        val actual = GetMaximumScore().maxSum(nums1, nums2)
        assertEquals(expected, actual)
    }
}
