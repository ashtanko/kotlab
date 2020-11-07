package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BestSightseeingPairTest {

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
    fun `best sightseeing pair test`(arr: IntArray, expected: Int) {
        assertEquals(expected, maxScoreSightseeingPair(arr))
    }
}
