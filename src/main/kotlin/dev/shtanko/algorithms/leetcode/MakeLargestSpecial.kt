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
 * 761. Special Binary String
 * @link https://leetcode.com/problems/special-binary-string/
 */
fun makeLargestSpecial(s: String): String {
    var count = 0
    var i = 0
    val res: MutableList<String> = ArrayList()
    for (j in s.indices) {
        if (s[j] == '1') {
            count++
        } else {
            count--
        }
        if (count == 0) {
            res.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + '0')
            i = j + 1
        }
    }
    return res.sortedDescending().joinToString("")
}