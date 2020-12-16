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

interface NumberOfStepsStrategy {
    fun perform(n: Int): Int
}

class NumberOfStepsStraightForward : NumberOfStepsStrategy {
    override fun perform(n: Int): Int {
        return n.numberOfSteps()
    }

    private fun Int.numberOfSteps(): Int {
        if (this == 0) return 0
        var result = 0
        var a = this
        var mod: Int
        while (a != 0) {
            mod = a % 2
            if (mod == 0) {
                a /= 2
            } else {
                a -= 1
            }
            result++
        }
        return result
    }
}

class NumberOfStepsBinary : NumberOfStepsStrategy {
    override fun perform(n: Int): Int {
        if (n == 0) return 0
        var result = 0
        var a = n
        while (a != 0) {
            result += if (a and 1 == 0) 1 else 2
            a = a shr 1
        }
        return result - 1
    }
}
