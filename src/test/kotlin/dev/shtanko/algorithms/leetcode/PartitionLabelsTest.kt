package dev.shtanko.algorithms.leetcode

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class PartitionLabelsTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of("", listOf<Int>()),
            Arguments.of("ababcbacadefegdehijhklij", listOf(9, 7, 8)),
            Arguments.of("abcdtyhr", listOf(1, 1, 1, 1, 1, 1, 1, 1)),
            Arguments.of("asdfagawertwe", listOf(7, 6)),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `partition labels test`(s: String, expected: List<Int>) {
        val actual = PartitionLabels().perform(s)
        assertThat(actual, equalTo(expected))
    }
}
