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

import kotlin.math.max

/**
 * 678. Valid Parenthesis String
 * @see <a href="https://leetcode.com/problems/valid-parenthesis-string/">Source</a>
 */
fun interface ValidParenthesisString {
    operator fun invoke(s: String): Boolean
}

/**
 * Approach #1: Brute Force Time Limit Exceeded
 */
class ValidParenthesisStringBruteForce : ValidParenthesisString {
    private var ans = false
    override fun invoke(s: String): Boolean {
        solve(StringBuilder(s), 0)
        return ans
    }

    private fun solve(sb: StringBuilder, i: Int) {
        if (i == sb.length) {
            ans = ans or valid(sb)
        } else if (sb[i] == '*') {
            for (c in "() ".toCharArray()) {
                sb.setCharAt(i, c)
                solve(sb, i + 1)
                if (ans) return
            }
            sb.setCharAt(i, '*')
        } else {
            solve(sb, i + 1)
        }
    }

    fun valid(sb: StringBuilder): Boolean {
        var bal = 0
        for (element in sb) {
            if (element == '(') bal++
            if (element == ')') bal--
            if (bal < 0) break
        }
        return bal == 0
    }
}

/**
 * Approach #2: Dynamic Programming
 */
class ValidParenthesisStringDP : ValidParenthesisString {
    override fun invoke(s: String): Boolean {
        val n: Int = s.length
        if (n == 0) return true
        val dp = Array(n) { BooleanArray(n) }

        for (i in 0 until n) {
            if (s[i] == '*') dp[i][i] = true
            val local = s[i] == '(' || s[i] == '*'
            if (i < n - 1 && local && (s[i + 1] == ')' || s[i + 1] == '*')) {
                dp[i][i + 1] = true
            }
        }
        dp(s, n, dp)
        return dp[0][n - 1]
    }

    private fun dp(s: String, n: Int, dp: Array<BooleanArray>) {
        for (size in 2 until n) {
            var i = 0
            while (i + size < n) {
                if (s[i] == '*' && dp[i + 1][i + size]) {
                    dp[i][i + size] = true
                } else if (s[i] == '(' || s[i] == '*') {
                    for (k in i + 1..i + size) {
                        val local = (s[k] == ')' || s[k] == '*') && (k == i + 1 || dp[i + 1][k - 1])
                        if (local && (k == i + size || dp[k + 1][i + size])) {
                            dp[i][i + size] = true
                        }
                    }
                }
                i++
            }
        }
    }
}

/**
 * Approach #3: Greedy
 */
class ValidParenthesisStringGreedy : ValidParenthesisString {
    override fun invoke(s: String): Boolean {
        var lo = 0
        var hi = 0
        for (c in s.toCharArray()) {
            lo += if (c == '(') 1 else -1
            hi += if (c != ')') 1 else -1
            if (hi < 0) break
            lo = max(lo, 0)
        }
        return lo == 0
    }
}
