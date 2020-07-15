package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DayOfTheWeekTest {

    @Test
    fun `simple test`() {
        val date = Triple(31, 8, 2019)

        assertEquals("Saturday", date.dayOfTheWeek())
    }

    @Test
    fun `simple test 2`() {
        val date = Triple(18, 7, 1999)
        assertEquals("Sunday", date.dayOfTheWeek())
    }

    @Test
    fun `simple test 3`() {
        val date = Triple(15, 8, 1993)
        assertEquals("Sunday", date.dayOfTheWeek())
    }

    @Test
    fun `simple test 4`() {
        val date = Triple(23, 4, 1994)
        assertEquals("Saturday", date.dayOfTheWeek())
    }
}
