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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal abstract class NthMagicalNumberTest<out T : NthMagicalNumberStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun numbersDataProvider(): Stream<Arguments?> = Stream.of(
            Arguments.of(1, 2, 3, 2),
            Arguments.of(4, 2, 3, 6),
            Arguments.of(5, 2, 4, 10),
            Arguments.of(3, 6, 4, 8)
        )
    }

    @ParameterizedTest
    @MethodSource("numbersDataProvider")
    internal fun `nth magical number test`(n: Int, a: Int, b: Int, expected: Int) {
        val actual = strategy.perform(n, a, b)
        assertEquals(expected, actual)
    }
}

internal class NthMagicalNumberMathTest : NthMagicalNumberTest<NthMagicalNumberMath>(NthMagicalNumberMath())

internal class NthMagicalNumberBSTest : NthMagicalNumberTest<NthMagicalNumberBS>(NthMagicalNumberBS())
