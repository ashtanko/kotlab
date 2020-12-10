package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DayOfTheWeekTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Triple<Int, Int, Int>, String>> {
            return listOf(
                Triple(28, 2, 2019) to "Thursday",
                Triple(31, 8, 2019) to "Saturday",
                Triple(18, 7, 1999) to "Sunday",
                Triple(15, 8, 1993) to "Sunday",
                Triple(23, 4, 1994) to "Saturday",
                Triple(27, 10, 1999) to "Wednesday",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `day of the week test`(testCase: Pair<Triple<Int, Int, Int>, String>) {
        val (date, expected) = testCase
        val actual = date.dayOfTheWeek()
        assertEquals(expected, actual)
    }
}
