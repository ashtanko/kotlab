package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CorporateFlightBookingsTest {

    @Test
    fun `simple test`() {
        val n = 5
        val bookings = arrayOf(
            intArrayOf(1, 2, 10),
            intArrayOf(2, 3, 20),
            intArrayOf(2, 5, 25)
        )
        val actual = corpFlightBookings(bookings, n)
        val expected = intArrayOf(10, 55, 45, 25, 25)
        assertArrayEquals(expected, actual)
    }
}
