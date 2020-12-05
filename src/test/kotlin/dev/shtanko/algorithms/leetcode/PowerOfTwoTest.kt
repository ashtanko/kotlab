package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class PowerOfTwoTest<out T : PowerOfTwoStrategy>(private val strategy: T) {
    companion object {
        @JvmStatic
        fun positiveCasesProvider(): List<Int> {
            return listOf(
                1,
                2,
                4,
                8,
                16,
                32,
                64,
                128,
                256,
                512,
                1024,
                2048,
                4096,
                8192,
                16_384,
                32_768,
                65_536,
                131_072,
                262_144,
                524_288,
                1_048_576,
                2_097_152,
                4_194_304,
                8_388_608,
                16_777_216,
                33_554_432,
                67_108_864,
                134_217_728,
                268_435_456,
                536_870_912,
                1_073_741_824
            )
        }

        @JvmStatic
        fun negativeCasesProvider(): List<Int> {
            return listOf(
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
    }

    @ParameterizedTest
    @MethodSource("positiveCasesProvider")
    internal fun `power of two test`(n: Int) {
        assertTrue(strategy.isPowerOfTwo(n))
    }

    @ParameterizedTest
    @MethodSource("negativeCasesProvider")
    internal fun `not power of two test`(n: Int) {
        assertFalse(strategy.isPowerOfTwo(n))
    }
}

internal class POTIterativeTest : PowerOfTwoTest<POTIterative>(POTIterative())

internal class POTBitwiseTest : PowerOfTwoTest<POTBitwise>(POTBitwise())
