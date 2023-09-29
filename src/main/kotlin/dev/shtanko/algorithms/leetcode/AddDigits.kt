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

private const val MAX = 9

/**
 * Add Digits
 * @see <a href="https://leetcode.com/problems/add-digits/">Source</a>
 */
fun interface AddDigits {
    operator fun invoke(num: Int): Int
}

class AddDigitsStraightForward : AddDigits {
    override operator fun invoke(num: Int): Int {
        var digitalRoot = 0
        var digits = num
        while (digits > 0) {
            digitalRoot += digits % DECIMAL
            digits /= DECIMAL
            if (digits == 0 && digitalRoot > MAX) {
                digits = digitalRoot
                digitalRoot = 0
            }
        }
        return digitalRoot
    }
}

class AddDigitsMath : AddDigits {
    override operator fun invoke(num: Int): Int {
        if (num == 0) return 0
        if (num % MAX == 0) return MAX
        return num % MAX
    }
}

class AddDigitsDigitalRoot : AddDigits {
    override operator fun invoke(num: Int): Int {
        return if (num == 0) 0 else 1 + (num - 1) % MAX
    }
}
