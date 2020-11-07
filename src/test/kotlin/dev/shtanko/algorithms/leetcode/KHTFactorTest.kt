package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class KHTFactorTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, Int>, Int>> {
            return listOf(
                12 to 3 to 3,
                7 to 2 to 7,
                4 to 4 to -1,
                1 to 1 to 1,
                1000 to 3 to 4
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `kth factor test`(testCase: Pair<Pair<Int, Int>, Int>) {
        val n = testCase.first.first
        val k = testCase.first.second
        val expected = testCase.second
        val actual = kthFactor(n, k)
        assertEquals(expected, actual)
    }
}
