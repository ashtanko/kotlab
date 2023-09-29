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
 * 115. Distinct Subsequences
 * @see <a href="https://leetcode.com/problems/distinct-subsequences/">Source</a>
 */
fun interface DistinctSubsequences {
    fun numDistinct(s: String, t: String): Int
}

class DistinctSubsequencesDP : DistinctSubsequences {
    override fun numDistinct(s: String, t: String): Int {
        // array creation
        val mem = Array(t.length + 1) { IntArray(s.length + 1) }

        // filling the first row: with 1s
        for (j in 0..s.length) {
            mem[0][j] = 1
        }

        // the first column is 0 by default in every other rows but the first, which we need.
        for (i in t.indices) {
            for (j in s.indices) {
                if (t[i] == s[j]) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j]
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j]
                }
            }
        }

        return mem[t.length][s.length]
    }
}
