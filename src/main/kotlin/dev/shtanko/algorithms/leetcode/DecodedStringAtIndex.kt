/*
 * Copyright 2023 Oleksii Shtanko
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
 * 880. Decoded String at Index
 * @see <a href="https://leetcode.com/problems/decoded-string-at-index">Source</a>
 */
interface DecodedStringAtIndex {
    operator fun invoke(s: String, k: Int): String
}

class DecodedStringAtIndexSolution : DecodedStringAtIndex {
    override fun invoke(s: String, k: Int): String {
        var n = 0
        var k0 = k

        var i = 0
        while (n < k0) {
            n = if (Character.isDigit(s[i])) n * (s[i] - '0') else n + 1
            i++
        }
        i--
        while (i > 0) {
            if (Character.isDigit(s[i])) {
                n /= s[i] - '0'
                k0 %= n
            } else {
                if (k0 % n == 0) {
                    break
                }
                n--
            }
            i--
        }
        return s[i].toString()
    }
}
