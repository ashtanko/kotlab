package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class OptimalDivisionTest<out T : OptimalDivisionStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<IntArray, String>> {
            return listOf(
                intArrayOf(1000, 100, 10, 2) to "1000/(100/10/2)"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `simple test`(testCase: Pair<IntArray, String>) {
        val nums = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(nums)
        assertEquals(expected, actual)
    }
}

class OptimalDivisionBruteForceTest : OptimalDivisionTest<OptimalDivisionBruteForce>(OptimalDivisionBruteForce())

class OptimalDivisionMemorizationTest : OptimalDivisionTest<OptimalDivisionMemorization>(OptimalDivisionMemorization())

class MathOptimalDivisionTest : OptimalDivisionTest<MathOptimalDivision>(MathOptimalDivision())
