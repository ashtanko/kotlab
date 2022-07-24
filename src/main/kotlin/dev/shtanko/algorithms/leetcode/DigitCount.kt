/*
 * Copyright 2022 Oleksii Shtanko
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

/**
 * 2283. Check if Number Has Equal Digit Count and Digit Value
 * link https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
 */
interface DigitCount {
    fun perform(num: String): Boolean
}

class DigitCountFreqArray : DigitCount {
    override fun perform(num: String): Boolean {
        val freq = IntArray(10)
        for (c in num.toCharArray()) {
            freq[c.code - '0'.code]++
        }
        for (i in num.indices) {
            if (num[i] - '0' != freq[i]) return false
        }
        return true
    }
}
