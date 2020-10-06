package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class PowerOfThreeTest<out T : PowerOfThreeStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun positiveCasesProvider(): List<Int> {
            return listOf(
                1,
                3,
                9,
                27,
                81,
                243,
                729,
                2_187,
                6_561,
                19_683,
                59_049,
                177_147,
                531_441,
                1_594_323,
                4_782_969,
                14_348_907,
                43_046_721,
                129_140_163,
                387_420_489,
                1_162_261_467
            )
        }

        @JvmStatic
        fun negativeCasesProvider(): List<Int> {
            return listOf(
                2,
                4,
                5,
                6,
                7,
                8,
                10)
        }
    }

    @ParameterizedTest
    @MethodSource("positiveCasesProvider")
    fun `power of tree test`(n: Int) {
        assertTrue(strategy.isPowerOfThree(n))
    }

    @ParameterizedTest
    @MethodSource("negativeCasesProvider")
    fun `not power of tree test`(n: Int) {
        assertFalse(strategy.isPowerOfThree(n))
    }
}

class POTLoopIterationTest : PowerOfThreeTest<POTLoopIteration>(POTLoopIteration())

class POTBaseConversionTest : PowerOfThreeTest<POTBaseConversion>(POTBaseConversion())

class POTMathematicsTest : PowerOfThreeTest<POTMathematics>(POTMathematics())

class POTIntegerLimitationsTest : PowerOfThreeTest<POTIntegerLimitations>(POTIntegerLimitations())
