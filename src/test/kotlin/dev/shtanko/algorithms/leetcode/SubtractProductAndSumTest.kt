package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SubtractProductAndSumTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                234 to 15,
                4421 to 21
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `subtract product and sum test`(testCase: Pair<Int, Int>) {
        val n = testCase.first
        val actual = n.subtractProductAndSum()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
