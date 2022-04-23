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

import dev.shtanko.algorithms.leetcode.DistinctSubseq2.Companion.ARR_SIZE

/**
 * 940. Distinct Subsequences II
 * @link https://leetcode.com/problems/distinct-subsequences-ii/
 */
interface DistinctSubseq2 {
    fun distinctSubseqII(s: String): Int

    companion object {
        const val ARR_SIZE = 26
    }
}

/**
 * Approach 1: Dynamic Programming
 */
class DistinctSubseq2DP : DistinctSubseq2 {
    override fun distinctSubseqII(s: String): Int {

        val n: Int = s.length
        val dp = IntArray(n + 1)
        dp[0] = 1

        val last = IntArray(ARR_SIZE) { -1 }

        for (i in 0 until n) {
            val x: Int = s[i] - 'a'
            dp[i + 1] = dp[i] * 2 % MOD
            if (last[x] >= 0) dp[i + 1] -= dp[last[x]]
            dp[i + 1] %= MOD
            last[x] = i
        }

        dp[n]--
        if (dp[n] < 0) dp[n] += MOD
        return dp[n]
    }
}

class DistinctSubseq2DPConstSpace : DistinctSubseq2 {
    override fun distinctSubseqII(s: String): Int {
        var pre = 1 // The number of subsequences till previous-location. Include empty string: ""

        var cur = 1 // The number of subsequences till now. Include empty string: ""

        val lastCount =
            IntArray(ARR_SIZE) // The number of subsequences that end with a character till now. Not include empty string: ""

        for (element in s) {
            val charIndex: Int = element - 'a'
            cur = pre * 2 % MOD // include-current-character  +  not-include-current-character
            cur -= lastCount[charIndex] // Remove duplicated characters: previous subsequences that end with current character.
            cur = if (cur >= 0) cur % MOD else cur + MOD
            lastCount[charIndex] = pre // The number of subsequences that end with current character.
            pre = cur
        }
        --cur // remove the empty string: ""

        return cur
    }
}