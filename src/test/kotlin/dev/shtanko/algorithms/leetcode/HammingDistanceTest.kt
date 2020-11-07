package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class HammingDistanceTest {

    companion object {

        @JvmStatic
        private fun provideCoordinates(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(1, 4, 2),
                Arguments.of(41, 88, 4)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideCoordinates")
    fun `simple test`(x: Int, y: Int, expected: Int) {
        val actual = hammingDistance(x, y)
        assertEquals(expected, actual)
    }
}
