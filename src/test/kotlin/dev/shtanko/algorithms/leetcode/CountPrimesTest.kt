package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class CountPrimesTest<out T : CountPrimesStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                0 to 0,
                1 to 0,
                3 to 1,
                4 to 2,
                5 to 2,
                7 to 3,
                11 to 4,
                10 to 4,
                13 to 5,
                1_000_000 to 78498
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Int, Int>) {
        val n = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(n)
        assertEquals(expected, actual)
    }
}

class CountPrimesBrutForceTest : CountPrimesTest<CountPrimesBrutForce>(CountPrimesBrutForce())

class CountPrimesTimeComplexityTest : CountPrimesTest<CountPrimesTimeComplexity>(CountPrimesTimeComplexity())
