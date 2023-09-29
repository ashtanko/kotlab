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

import kotlin.math.max

/**
 * 1143. Longest Common Subsequence
 * @see <a href="https://leetcode.com/problems/longest-common-subsequence">Source</a>
 */
fun interface LongestCommonSubsequence {
    operator fun invoke(text1: String, text2: String): Int
}

class LongestCommonSubsequenceDP : LongestCommonSubsequence {
    override operator fun invoke(text1: String, text2: String): Int {
        if (text1.length < text2.length) {
            return lcp(text1, text2)
        }
        return lcp(text2, text1)
    }

    private fun lcp(s1: String, s2: String): Int {
        val m = Array(2) { IntArray(s1.length + 1) }
        // row represents the length of s2, col represents the length of s1
        for (i in 1..s2.length) {
            // base case
            m[i % 2][0] = 0
            for (j in 1..s1.length) {
                if (s1[j - 1] == s2[i - 1]) {
                    m[i % 2][j] = m[(i - 1) % 2][j - 1] + 1
                } else {
                    m[i % 2][j] = max(
                        m[(i - 1) % 2][j - 1],
                        max(m[(i - 1) % 2][j], m[i % 2][j - 1]),
                    )
                }
            }
        }
        return m[s2.length % 2][s1.length]
    }
}
