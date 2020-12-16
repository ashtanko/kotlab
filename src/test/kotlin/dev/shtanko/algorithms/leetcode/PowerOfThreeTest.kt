/*
 * Copyright 2020 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class PowerOfThreeTest<out T : PowerOfThreeStrategy>(private val strategy: T) {

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
    }

    @ParameterizedTest
    @MethodSource("positiveCasesProvider")
    internal fun `power of tree test`(n: Int) {
        val actual = strategy.isPowerOfThree(n)
        assertTrue(actual)
    }

    @ParameterizedTest
    @MethodSource("negativeCasesProvider")
    internal fun `not power of tree test`(n: Int) {
        val actual = strategy.isPowerOfThree(n)
        assertFalse(actual)
    }
}

internal class POTLoopIterationTest : PowerOfThreeTest<POTLoopIteration>(POTLoopIteration())

internal class POTBaseConversionTest : PowerOfThreeTest<POTBaseConversion>(POTBaseConversion())

internal class POTMathematicsTest : PowerOfThreeTest<POTMathematics>(POTMathematics())

internal class POTIntegerLimitationsTest : PowerOfThreeTest<POTIntegerLimitations>(POTIntegerLimitations())
