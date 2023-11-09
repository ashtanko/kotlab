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

import dev.shtanko.algorithms.MOD

/**
 * 1397. Find All Good Strings
 * @see <a href="https://leetcode.com/problems/find-all-good-strings/">Source</a>
 */
fun interface FindGoodStrings {
    operator fun invoke(n: Int, s1: String, s2: String, evil: String): Int
}

class FindGoodStringsDFS : FindGoodStrings {
    override operator fun invoke(n: Int, s1: String, s2: String, evil: String): Int {
        val dp = IntArray(1 shl BITS) // Need total 17 bits, can check getKey() function

        return dfs(
            0, 0, true,
            rightBound = true,
            n = n,
            s1 = s1.toCharArray(),
            s2 = s2.toCharArray(),
            evil = evil.toCharArray(),
            lps = computeLPS(evil.toCharArray()),
            dp = dp,
        )
    }

    private fun dfs(
        i: Int,
        evilMatched: Int,
        leftBound: Boolean,
        rightBound: Boolean,
        n: Int,
        s1: CharArray,
        s2: CharArray,
        evil: CharArray,
        lps: IntArray,
        dp: IntArray,
    ): Int {
        if (evilMatched == evil.size) return 0 // contain `evil` as a substring -> not good string
        if (i == n) return 1 // it's a good string
        val key = getKey(i, evilMatched, leftBound, rightBound)
        if (dp[key] != 0) return dp[key]
        val from = if (leftBound) s1[i] else 'a'
        val to = if (rightBound) s2[i] else 'z'
        var res = 0
        var c = from
        while (c <= to) {
            var j = evilMatched // j means the next match between current string (end at char `c`) and `evil` string
            while (j > 0 && evil[j] != c) {
                j = lps[j - 1]
            }
            if (c == evil[j]) {
                j++
            }
            res += dfs(
                i + 1, j, leftBound && c == from, rightBound && c == to,
                n, s1, s2, evil, lps, dp,
            )
            res %= MOD
            c++
        }
        return res.also { dp[key] = it }
    }

    private fun getKey(n: Int, m: Int, b1: Boolean, b2: Boolean): Int {
        // Need 9 bits store n (2^9=512), 6 bits store m (2^6=64), 1 bit store b1, 1 bit store b2
        return n shl 8 or (m shl 2) or ((if (b1) 1 else 0) shl 1) or if (b2) 1 else 0
    }

    private fun computeLPS(str: CharArray): IntArray { // Longest Prefix also Suffix
        val n = str.size
        val lps = IntArray(n)
        var i = 1
        var j = 0
        while (i < n) {
            while (j > 0 && str[i] != str[j]) {
                j = lps[j - 1]
            }
            if (str[i] == str[j]) {
                lps[i] = ++j
            }
            i++
        }
        return lps
    }

    companion object {
        private const val BITS = 17
    }
}
