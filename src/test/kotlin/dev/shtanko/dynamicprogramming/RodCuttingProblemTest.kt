package dev.shtanko.dynamicprogramming

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RodCuttingProblemTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Int>> {
            return listOf(
                intArrayOf(2, 5, 7, 8) to 5 to 12,
                intArrayOf(1, 5, 8, 9, 10, 17, 17, 20) to 4 to 10
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `cut rod test`(testCase: Pair<Pair<IntArray, Int>, Int>) {
        val expected = testCase.second
        val actual = cutRod(testCase.first.first, testCase.first.second)
        assertEquals(expected, actual)
    }
}
