package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SumEvenAfterQueriesTest {

    @Test
    fun `simple test`() {
        val a = intArrayOf(1, 2, 3, 4)
        val queries = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-3, 1),
            intArrayOf(-4, 0),
            intArrayOf(2, 3)
        )
        val actual = sumEvenAfterQueries(a, queries)
        val expected = intArrayOf(8, 6, 2, 4)
        assertArrayEquals(expected, actual)
    }
}
