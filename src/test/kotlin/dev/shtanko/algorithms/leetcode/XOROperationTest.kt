package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class XOROperationTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, Int>, Int>> {
            return listOf(
                5 to 0 to 8,
                4 to 3 to 8,
                1 to 7 to 7,
                10 to 5 to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<Int, Int>, Int>) {
        val expected = testCase.second
        val actual = testCase.first.first.xorOperation(testCase.first.second)
        assertEquals(expected, actual)
    }
}
