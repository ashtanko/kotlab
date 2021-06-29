/*
 * Copyright 2021 Alexey Shtanko
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

import kotlin.math.max

/**
 * 3. Longest Substring Without Repeating Characters
 * @link https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
interface LengthOfLongestSubstring {
    fun perform(s: String): Int
}

/**
 * Approach 1: Brute Force
 * Time complexity : O(n^3).
 * Space complexity : O(min(n,m)).
 */
class LengthOfLongestSubstringBF : LengthOfLongestSubstring {
    override fun perform(s: String): Int {
        val n: Int = s.length
        var res = 0
        for (i in 0 until n) {
            for (j in i until n) {
                if (checkRepetition(s, i, j)) {
                    res = max(res, j - i + 1)
                }
            }
        }

        return res
    }

    private fun checkRepetition(s: String, start: Int, end: Int): Boolean {
        val chars = IntArray(MAXIMUM_VALUE)
        for (i in start..end) {
            val c = s[i]
            chars[c.toInt()]++
            if (chars[c.toInt()] > 1) {
                return false
            }
        }
        return true
    }

    companion object {
        private const val MAXIMUM_VALUE = 128
    }
}
