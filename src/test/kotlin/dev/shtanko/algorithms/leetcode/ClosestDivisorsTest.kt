package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ClosestDivisorsTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, IntArray>> {
            return listOf(
                Pair(8, intArrayOf(3, 3)),
                Pair(123, intArrayOf(5, 25)),
                Pair(999, intArrayOf(25, 40))
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Int, IntArray>) {
        val num = testCase.first
        val expected = testCase.second
        val actual = closestDivisors(num)
        assertArrayEquals(expected, actual)
    }
}
