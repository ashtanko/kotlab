/*
 * Copyright 2021 Oleksii Shtanko
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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class BitwiseComplementTest<out T : BitwiseComplement>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0,
                1
            ),
            Arguments.of(
                5,
                2
            ),
            Arguments.of(
                7,
                0
            ),
            Arguments.of(
                10,
                5
            ),
            Arguments.of(
                10_000,
                6383
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `bitwise complement test`(n: Int, expected: Int) {
        val actual = strategy.perform(n)
        assertThat(actual).isEqualTo(expected)
    }
}

internal class BitwiseComplementFlipBitTest :
    BitwiseComplementTest<BitwiseComplementFlipBit>(BitwiseComplementFlipBit())

internal class BitwiseComplementBitmaskTest :
    BitwiseComplementTest<BitwiseComplementBitmask>(BitwiseComplementBitmask())

internal class BitwiseComplementBuiltInFuncTest :
    BitwiseComplementTest<BitwiseComplementBuiltInFunc>(BitwiseComplementBuiltInFunc())

internal class HighestOneBitTest : BitwiseComplementTest<HighestOneBit>(HighestOneBit())

internal class BitwiseComplementBruteForceTest :
    BitwiseComplementTest<BitwiseComplementBruteForce>(BitwiseComplementBruteForce())
