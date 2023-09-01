/*
 * Copyright 2021 Oleksii Shtanko
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

import kotlin.math.min

/**
 * Count Binary Substrings
 * @see <a href="https://leetcode.com/problems/count-binary-substrings/solution/">leetcode page</a>
 */
interface CountBinarySubstrings {
    operator fun invoke(s: String): Int
}

/**
 * Approach #1: Group By Character
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class GroupByCharacter : CountBinarySubstrings {
    override operator fun invoke(s: String): Int {
        val groups = IntArray(s.length)
        var t = 0
        groups[0] = 1
        for (i in 1 until s.length) {
            if (s[i - 1] != s[i]) {
                groups[++t] = 1
            } else {
                groups[t]++
            }
        }

        var ans = 0
        for (i in 1..t) {
            ans += min(groups[i - 1], groups[i])
        }
        return ans
    }
}

/**
 * Approach #2: Linear Scan
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class CBSLinearScan : CountBinarySubstrings {
    override operator fun invoke(s: String): Int {
        var ans = 0
        var prev = 0
        var cur = 1
        for (i in 1 until s.length) {
            if (s[i - 1] != s[i]) {
                ans += min(prev, cur)
                prev = cur
                cur = 1
            } else {
                cur++
            }
        }
        return ans + min(prev, cur)
    }
}
