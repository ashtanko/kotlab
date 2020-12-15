package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class SplitArrayIntoConsecutiveSubsequencesTest<out T : SplitArrayIntoConsecutiveSubsequences>(
    private val strategy: T
) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 2, 3, 3, 4, 5), true),
            Arguments.of(intArrayOf(1, 2, 3, 3, 4, 4, 5, 5), true),
            Arguments.of(intArrayOf(1, 2, 3, 4, 4, 5), false),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `is possible test`(nums: IntArray, expected: Boolean) {
        val actual = strategy.isPossible(nums)
        assertThat(actual, equalTo(expected))
    }
}

internal class SplitArrayIntoConsecutiveSubsequencesQueueTest :
    SplitArrayIntoConsecutiveSubsequencesTest<SplitArrayIntoConsecutiveSubsequencesQueue>(
        SplitArrayIntoConsecutiveSubsequencesQueue()
    )

internal class SplitArrayIntoConsecutiveSubsequencesGreedyTest :
    SplitArrayIntoConsecutiveSubsequencesTest<SplitArrayIntoConsecutiveSubsequencesGreedy>(
        SplitArrayIntoConsecutiveSubsequencesGreedy()
    )
