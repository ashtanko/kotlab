package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CountGoodTripletsTest {

    companion object {

        @JvmStatic
        private fun provideNumbers(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(intArrayOf(3, 0, 1, 1, 9, 7), 7, 2, 3, 4),
                Arguments.of(intArrayOf(1, 1, 2, 2, 3), 0, 0, 1, 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    internal fun `count good triplets test`(arr: IntArray, a: Int, b: Int, c: Int, expected: Int) {
        val actual = countGoodTriplets(arr, a, b, c)
        assertEquals(expected, actual)
    }
}
