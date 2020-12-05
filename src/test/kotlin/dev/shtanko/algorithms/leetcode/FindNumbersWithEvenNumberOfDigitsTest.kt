package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class FindNumbersWithEvenNumberOfDigitsTest {

    companion object {

        @JvmStatic
        private fun provideNumbers(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(intArrayOf(12, 345, 2, 6, 7896), 2),
                Arguments.of(intArrayOf(555, 901, 482, 1771), 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    internal fun `find numbers test`(nums: IntArray, expected: Int) {
        val actual = nums.findNumbers()
        assertEquals(expected, actual)
    }
}
