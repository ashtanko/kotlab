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

private const val COUNT_CHARACTERS_COUNT = 26

fun Array<String>.countCharacters(chars: String): Int {
    val arr = IntArray(COUNT_CHARACTERS_COUNT)
    for (ch in chars.toCharArray()) {
        arr[ch - 'a']++
    }
    var ans = 0
    for (s in this) {
        val clone = arr.clone()
        for (i in s.indices) {
            clone[s[i] - 'a']--
            if (clone[s[i] - 'a'] < 0) {
                break
            }
            if (i == s.length - 1) {
                ans += s.length
            }
        }
    }
    return ans
}
