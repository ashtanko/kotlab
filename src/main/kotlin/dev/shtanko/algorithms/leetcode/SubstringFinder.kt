/*
 * Copyright 2023 Oleksii Shtanko
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

import kotlin.math.max

/**
 * 1624. Largest Substring Between Two Equal Characters
 * @see <a href="https://leetcode.com/problems/largest-substring-between-two-equal-characters">Source</a>
 */
fun interface SubstringFinder {
    operator fun invoke(s: String): Int
}

class SubstringFinderBF : SubstringFinder {
    override fun invoke(s: String): Int {
        var ans = -1
        for (left in s.indices) {
            for (right in left + 1 until s.length) {
                if (s[left] == s[right]) {
                    ans = max(ans.toDouble(), (right - left - 1).toDouble()).toInt()
                }
            }
        }

        return ans
    }
}

class SubstringFinderHashMap : SubstringFinder {
    override fun invoke(s: String): Int {
        val firstIndex: MutableMap<Char, Int> = HashMap()
        var ans = -1

        for (i in s.indices) {
            if (firstIndex.containsKey(s[i])) {
                ans = max(ans.toDouble(), (i - firstIndex.getOrDefault(s[i], 0) - 1).toDouble())
                    .toInt()
            } else {
                firstIndex[s[i]] = i
            }
        }

        return ans
    }
}
