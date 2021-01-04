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
import org.junit.jupiter.params.provider.MethodSource

internal abstract class BinaryGapTest<out T : BinaryGapStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                22 to 2,
                5 to 2,
                6 to 1,
                8 to 0,
                4 to 0,
                15 to 1,
                7 to 1,
                16 to 0,
                23 to 2,
                42 to 2,
                56 to 1,
                114 to 3,
                2345 to 3,
                Int.MAX_VALUE to 1,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `binary gap test`(testCase: Pair<Int, Int>) {
        val (n, expected) = testCase
        val actual = strategy.binaryGap(n)
        assertEquals(expected, actual)
    }
}

internal class BGStoreIndexesTest : BinaryGapTest<BGStoreIndexes>(BGStoreIndexes())

internal class BGOnePassTest : BinaryGapTest<BGOnePass>(BGOnePass())

internal class BGOtherTest : BinaryGapTest<BGOther>(BGOther())
