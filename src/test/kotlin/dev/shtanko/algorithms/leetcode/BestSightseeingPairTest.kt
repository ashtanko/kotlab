package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BestSightseeingPairTest {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(intArrayOf(8, 1, 5, 2, 6), 11)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `best sightseeing pair test`(arr: IntArray, expected: Int) {
        val actual = maxScoreSightseeingPair(arr)
        assertEquals(expected, actual)
    }
}
