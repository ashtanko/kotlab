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
 * 1312. Minimum Insertion Steps to Make a String Palindrome
 * @link https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */
interface MinInsertionsPalindrome {
    fun minInsertions(s: String): Int
}

/**
 * Longest Common Sequence
 */
class MinInsertionsPalindromeLCS : MinInsertionsPalindrome {
    override fun minInsertions(s: String): Int {
        val n: Int = s.length
        val dp = Array(n + 1) { IntArray(n + 1) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                dp[i + 1][j + 1] = if (s[i] == s[n - 1 - j]) {
                    dp[i][j] + 1
                } else {
                    max(dp[i][j + 1], dp[i + 1][j])
                }
            }
        }
        return n - dp[n][n]
    }
}
