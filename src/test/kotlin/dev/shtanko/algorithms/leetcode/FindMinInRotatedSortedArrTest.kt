package dev.shtanko.algorithms.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class FindMinInRotatedSortedArrTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(3, 4, 5, 1, 2),
                1
            ),
            Arguments.of(
                intArrayOf(4, 5, 6, 7, 0, 1, 2),
                0
            ),
            Arguments.of(
                intArrayOf(11, 13, 15, 17),
                11
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `find min in rotated sorted array test`(nums: IntArray, expected: Int) {
        val actual = findMinInRotatedSortedArr(nums)
        assertThat(actual).isEqualTo(expected)
    }
}
