package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ValidSubArraysTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 4, 2, 5, 3), 11),
            Arguments.of(intArrayOf(3, 2, 1), 3),
            Arguments.of(intArrayOf(2, 2, 2), 6)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `valid sub arrays test`(nums: IntArray, expected: Int) {
        val actual = ValidSubArrays().perform(nums)
        assertEquals(expected, actual)
    }
}
