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

fun interface PowerOfTwoStrategy {
    operator fun invoke(num: Int): Boolean
}

class PowerOfTwoIterative : PowerOfTwoStrategy {
    override fun invoke(num: Int): Boolean {
        var num1 = num
        if (num1 <= 0) return false
        while (num1 % 2 == 0) num1 /= 2
        return num1 == 1
    }
}

class PowerOfTwoBitwise : PowerOfTwoStrategy {
    override fun invoke(num: Int): Boolean {
        return if (num < 1) {
            false
        } else {
            0 == num - 1 and num
        }
    }
}
