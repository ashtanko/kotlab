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

/**
 * Wildcard Matching
 */
fun Pair<String, String>.isMatch(): Boolean {
    val m = first.length
    val n = second.length
    val ws = first.toCharArray()
    val wp = second.toCharArray()
    val dp = Array(m + 1) { BooleanArray(n + 1) }
    dp[0][0] = true
    for (j in 1..n) dp[0][j] = dp[0][j - 1] && wp[j - 1] == '*'
    for (i in 1..m) dp[i][0] = false
    for (i in 1..m) {
        for (j in 1..n) {
            if (wp[j - 1] == '?' || ws[i - 1] == wp[j - 1]) dp[i][j] =
                dp[i - 1][j - 1] else if (wp[j - 1] == '*') dp[i][j] =
                dp[i - 1][j] || dp[i][j - 1]
        }
    }
    return dp[m][n]
}
