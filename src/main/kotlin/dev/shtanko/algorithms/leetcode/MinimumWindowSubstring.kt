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
 * 76. Minimum Window Substring
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">Source</a>
 */
fun interface MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String
}

/**
 * Approach 1: Sliding Window
 */
class MWSSlidingWindow : MinimumWindowSubstring {
    override fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) {
            return ""
        }

        val map = IntArray(LIMIT)
        for (c in t.toCharArray()) {
            map[c.code]++
        }
        var start = 0
        var end = 0
        var minStart = 0
        var minLen = Int.MAX_VALUE
        var counter: Int = t.length
        while (end < s.length) {
            val c1: Char = s[end]
            if (map[c1.code] > 0) counter--
            map[c1.code]--
            end++
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start
                    minStart = start
                }
                val c2: Char = s[start]
                map[c2.code]++
                if (map[c2.code] > 0) counter++
                start++
            }
        }

        return if (minLen == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(minStart, minStart + minLen)
        }
    }

    companion object {
        private const val LIMIT = 128
    }
}

/**
 * Approach 2: Optimized Sliding Window
 */
class MWSSlidingLongestSubstring : MinimumWindowSubstring {
    override fun minWindow(s: String, t: String): String {
        if (s.isEmpty() || t.isEmpty()) {
            return ""
        }

        val map: HashMap<Char, Int> = HashMap()
        for (c in s.toCharArray()) map[c] = 0
        for (c in t.toCharArray()) {
            if (map.containsKey(c)) map[c] = map[c]!! + 1 else return ""
        }

        var start = 0
        var end = 0
        var minStart = 0
        var minLen = Int.MAX_VALUE
        var counter: Int = t.length
        while (end < s.length) {
            val c1: Char = s[end]
            if (map[c1]!! > 0) counter--
            map[c1] = map[c1]!! - 1
            end++
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start
                    minStart = start
                }
                val c2: Char = s[start]
                map[c2] = map[c2]!! + 1
                if (map[c2]!! > 0) counter++
                start++
            }
        }
        return if (minLen == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(minStart, minStart + minLen)
        }
    }
}
