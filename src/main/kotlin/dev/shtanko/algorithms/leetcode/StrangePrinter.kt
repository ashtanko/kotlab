/*
 * Copyright 2023 Oleksii Shtanko
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
 * 664. Strange Printer
 * @see <a href="https://leetcode.com/problems/strange-printer/">leetcode page</a>
 */
fun interface StrangePrinter {
    operator fun invoke(s: String): Int
}

/**
 * Approach 1: Bottom-Up Dynamic Programming
 */
class StrangePrinterBottomUp : StrangePrinter {
    override operator fun invoke(s: String): Int {
        val n: Int = s.length
        val dp = Array(n) { IntArray(n) }
        for (length in 1..n) {
            for (left in 0..n - length) {
                val right = left + length - 1
                var j = -1
                dp[left][right] = n
                for (i in left until right) {
                    if (s[i] != s[right] && j == -1) {
                        j = i
                    }
                    if (j != -1) {
                        dp[left][right] =
                            min(dp[left][right].toDouble(), (1 + dp[j][i] + dp[i + 1][right]).toDouble())
                                .toInt()
                    }
                }
                if (j == -1) {
                    dp[left][right] = 0
                }
            }
        }

        return dp[0][n - 1] + 1
    }
}

/**
 * Approach 2: Top-Down Dynamic Programming (Memoization)
 */
class StrangePrinterTopDown : StrangePrinter {
    private lateinit var dp: Array<IntArray>

    override operator fun invoke(s: String): Int {
        val n: Int = s.length
        dp = Array(n) { IntArray(n) }
        for (left in 0 until n) {
            for (right in 0 until n) {
                dp[left][right] = -1
            }
        }

        return solve(s, n, 0, n - 1) + 1
    }

    private fun solve(s: String, n: Int, left: Int, right: Int): Int {
        if (dp[left][right] != -1) {
            return dp[left][right]
        }
        dp[left][right] = n
        var j = -1
        for (i in left until right) {
            if (s[i] != s[right] && j == -1) {
                j = i
            }
            if (j != -1) {
                dp[left][right] =
                    min(dp[left][right].toDouble(), (1 + solve(s, n, j, i) + solve(s, n, i + 1, right)).toDouble())
                        .toInt()
            }
        }
        if (j == -1) {
            dp[left][right] = 0
        }
        return dp[left][right]
    }
}
