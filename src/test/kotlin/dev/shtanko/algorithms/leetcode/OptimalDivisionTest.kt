package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class OptimalDivisionTest<out T : OptimalDivisionStrategy>(private val strategy: T) {

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
    internal fun `optimal division test`(testCase: Pair<IntArray, String>) {
        val (nums, expected) = testCase
        val actual = strategy.perform(nums)
        assertEquals(expected, actual)
    }
}

internal class OptimalDivisionBruteForceTest :
    OptimalDivisionTest<OptimalDivisionBruteForce>(OptimalDivisionBruteForce())

internal class OptimalDivisionMemorizationTest :
    OptimalDivisionTest<OptimalDivisionMemorization>(OptimalDivisionMemorization())

internal class MathOptimalDivisionTest : OptimalDivisionTest<MathOptimalDivision>(MathOptimalDivision())
