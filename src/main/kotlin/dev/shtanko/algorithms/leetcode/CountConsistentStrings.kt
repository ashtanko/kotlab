/*
 * Copyright 2022 Oleksii Shtanko
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

/**
 * 1684. Count the Number of Consistent Strings
 * @see <a href="https://leetcode.com/problems/count-the-number-of-consistent-strings/">Source</a>
 */
fun interface CountConsistentStrings {
    operator fun invoke(allowed: String, words: Array<String>): Int
}

class CountConsistentStringsMap : CountConsistentStrings {
    override operator fun invoke(allowed: String, words: Array<String>): Int {
        var ans = 0
        val map = HashSet<Char>()
        for (ch in allowed.toCharArray()) {
            map.add(ch)
        }
        var c: Int
        for (s in words) {
            c = 0
            for (ch in s.toCharArray()) {
                if (!map.contains(ch)) {
                    c++
                }
            }
            if (c == 0) {
                ans++
            }
        }
        return ans
    }
}
