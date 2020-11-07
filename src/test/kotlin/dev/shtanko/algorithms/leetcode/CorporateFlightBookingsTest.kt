package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CorporateFlightBookingsTest {

    companion object {

        @JvmStatic
        private fun provideDataFlights(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    arrayOf(
                        intArrayOf(1, 2, 10),
                        intArrayOf(2, 3, 20),
                        intArrayOf(2, 5, 25)
                    ),
                    5,
                    intArrayOf(10, 55, 45, 25, 25)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataFlights")
    fun `simple test`(bookings: Array<IntArray>, n: Int, expected: IntArray) {
        val actual = corpFlightBookings(bookings, n)
        assertArrayEquals(expected, actual)
    }
}
