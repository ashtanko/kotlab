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

package dev.shtanko.algorithms.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class GCDTest {

    companion object {
        @JvmStatic
        fun dataProvider(): Stream<Arguments?> = Stream.of(
            Arguments.of(54, 24, 6),
            Arguments.of(42, 56, 14)
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `gcd pair test`(a: Int, b: Int, expected: Int) {
        val actual = (a to b).gcd()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `gcd recursive test`(a: Int, b: Int, expected: Int) {
        val actual = gcd(a, b)
        assertEquals(expected, actual)
    }
}
