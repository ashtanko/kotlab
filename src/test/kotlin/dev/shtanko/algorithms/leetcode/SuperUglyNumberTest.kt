/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
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

abstract class SuperUglyNumberTest<out T : SuperUglyNumberStrategy>(private val strategy: T) {
    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<Int, IntArray>, Int>> {
            return listOf(
                12 to intArrayOf(2, 7, 13, 19) to 32,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `super ugly number test`(testCase: Pair<Pair<Int, IntArray>, Int>) {
        val (data, expected) = testCase
        val (n, primes) = data
        val actual = strategy.invoke(n, primes)
        assertEquals(expected, actual)
    }
}

class SuperUglyNumberCommonTest : SuperUglyNumberTest<SuperUglyNumberCommon>(SuperUglyNumberCommon())

class SuperUglyNumberRedundantMultiplicationTest :
    SuperUglyNumberTest<SuperUglyNumberRedundantMultiplication>(SuperUglyNumberRedundantMultiplication())

class SuperUglyNumberHeapTest :
    SuperUglyNumberTest<SuperUglyNumberHeap>(SuperUglyNumberHeap())
