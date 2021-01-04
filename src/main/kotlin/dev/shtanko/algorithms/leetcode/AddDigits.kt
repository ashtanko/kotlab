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

private const val MAX = 9

/**
 * Add Digits
 * @link https://leetcode.com/problems/add-digits/
 */
interface AddDigitsStrategy {
    fun perform(digits: Int): Int
}

class AddDigitsStraightForward : AddDigitsStrategy {
    override fun perform(digits: Int): Int {
        var digitalRoot = 0
        var num = digits
        while (num > 0) {
            digitalRoot += num % DECIMAL
            num /= DECIMAL
            if (num == 0 && digitalRoot > MAX) {
                num = digitalRoot
                digitalRoot = 0
            }
        }
        return digitalRoot
    }
}

class AddDigitsMath : AddDigitsStrategy {
    override fun perform(digits: Int): Int {
        if (digits == 0) return 0
        if (digits % MAX == 0) return MAX
        return digits % MAX
    }
}
