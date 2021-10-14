/*
 * Copyright 2021 Alexey Shtanko
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

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal abstract class CountVowelsPermutationTest<out T : CountVowelsPermutationStrategy>(private val strategy: T) {

    @TestFactory
    fun `count vowel permutation strategies test`() = listOf(
        1 to 5,
        2 to 10,
        5 to 68
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("dp $strategy count vowel permutation of $input then get $expected") {
            Assertions.assertEquals(expected, strategy.perform(input))
        }
    }
}

internal class CountVowelsPermutationBottomUpTest :
    CountVowelsPermutationTest<CountVowelsPermutation.BottomUp>(CountVowelsPermutation.BottomUp())

internal class CountVowelsPermutationOptimizedSpaceTest :
    CountVowelsPermutationTest<CountVowelsPermutation.OptimizedSpace>(CountVowelsPermutation.OptimizedSpace())

internal class CountVowelsPermutationTopDownTest :
    CountVowelsPermutationTest<CountVowelsPermutation.TopDown>(CountVowelsPermutation.TopDown())