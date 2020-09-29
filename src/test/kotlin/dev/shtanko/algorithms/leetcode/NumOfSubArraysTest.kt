package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NumOfSubArraysTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                4 to listOf(1, 3, 5),
                0 to listOf(2, 4, 6)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(data: Pair<Int, List<Int>>) {
        val expected = data.first
        assertEquals(expected, numOfSubArrays(data.second.toIntArray()))
    }
}
