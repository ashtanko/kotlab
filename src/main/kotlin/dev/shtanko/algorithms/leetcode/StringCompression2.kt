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

import dev.shtanko.algorithms.DECIMAL
import kotlin.math.min

/**
 * 1531. String Compression II
 * @see <a href="https://leetcode.com/problems/string-compression-ii/">Source</a>
 */
fun interface StringCompression2 {
    operator fun invoke(s: String, k: Int): Int
}

class StringCompression2DP : StringCompression2 {
    override fun invoke(s: String, k: Int): Int {
        val n: Int = s.length
        val dp = Array(n + 1) { IntArray(k + 1) { n } }
        dp[0][0] = 0

        for (i in 1..n) {
            for (m in 0..k) {
                if (m > 0) {
                    dp[i][m] = min(dp[i][m], dp[i - 1][m - 1])
                }

                // keep s[i], concat the same, remove the different
                var same = 0
                var diff = 0
                for (j in i downTo 1) {
                    if (s[j - 1] == s[i - 1]) same++ else diff++
                    if (diff > m) break
                    dp[i][m] = min(dp[i][m], dp[j - 1][m - diff] + getLen(same))
                }
            }
        }
        return dp[n][k]
    }

    private fun getLen(count: Int): Int {
        return when {
            count == 1 -> 1
            count < DECIMAL -> 2
            count < LIMIT -> 3
            else -> 4
        }
    }

    companion object {
        private const val LIMIT = 100
    }
}
