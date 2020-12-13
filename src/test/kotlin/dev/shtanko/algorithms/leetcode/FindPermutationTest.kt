package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class FindPermutationTest<out T : FindPermutation>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("I", intArrayOf(1, 2)),
            Arguments.of("DI", intArrayOf(2, 1, 3)),
            Arguments.of("DDIIDI", intArrayOf(3, 2, 1, 4, 6, 5, 7)),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `find permutation test`(s: String, expected: IntArray) {
        val actual = strategy.perform(s)
        assertThat(actual, equalTo(expected))
    }
}

internal class FindPermutationStackTest : FindPermutationTest<FindPermutationStack>(FindPermutationStack())
internal class FindPermutationReversingTest : FindPermutationTest<FindPermutationReversing>(FindPermutationReversing())
internal class FindPermutationTwoPointersTest :
    FindPermutationTest<FindPermutationTwoPointers>(FindPermutationTwoPointers())
