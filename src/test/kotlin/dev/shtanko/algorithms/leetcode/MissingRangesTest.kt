package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MissingRangesTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 3, 50, 75),
                0,
                99,
                listOf("2", "4->49", "51->74", "76->99")
            ),
            Arguments.of(
                intArrayOf(),
                1,
                1,
                listOf("1")
            ),
            Arguments.of(
                intArrayOf(),
                -3,
                -1,
                listOf("-3->-1")
            ),
            Arguments.of(
                intArrayOf(-1),
                -1,
                -1,
                listOf<String>()
            ),
            Arguments.of(
                intArrayOf(-1),
                -2,
                -1,
                listOf("-2")
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `find missing ranges test`(nums: IntArray, lower: Int, upper: Int, expected: List<String>) {
        val actual = MissingRanges().findMissingRanges(nums, lower, upper)
        assertEquals(expected, actual)
    }
}
