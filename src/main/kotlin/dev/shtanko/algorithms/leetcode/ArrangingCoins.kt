/*
 * Copyright 2020 Oleksii Shtanko
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

import kotlin.math.sqrt

fun interface ArrangingCoinsStrategy {
    fun arrangeCoins(n: Int): Int
}

class ArrangingCoinsBS : ArrangingCoinsStrategy {
    override fun arrangeCoins(n: Int): Int {
        var left = 0
        var right = n
        var k: Int
        var curr: Int

        while (left <= right) {
            k = left + right.minus(left) / 2
            curr = k * k.plus(1) / 2
            if (curr == n) return k
            if (n < curr) {
                right = k - 1
            } else {
                left = k + 1
            }
        }
        return right
    }
}

class ArrangingCoinsMath : ArrangingCoinsStrategy {

    override fun arrangeCoins(n: Int): Int {
        val local = sqrt(C1 * n + C2) - C3
        return local.toInt()
    }

    companion object {
        private const val C1 = 2
        private const val C2 = 0.25
        private const val C3 = 0.5
    }
}
