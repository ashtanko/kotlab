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

import kotlin.math.min

/**
 * 1416. Restore The Array
 * @link https://leetcode.com/problems/restore-the-array/
 */
interface RestoreTheArray {
    fun numberOfArrays(s: String, k: Int): Int
}

class RestoreTheArrayMemoization : RestoreTheArray {
    override fun numberOfArrays(s: String, k: Int): Int {
        val dp = arrayOfNulls<Int>(s.length) // dp[i] is number of ways to print valid arrays from string s start at i

        return dfs(s, k.toLong(), 0, dp)
    }

    private fun dfs(s: String, k: Long, i: Int, dp: Array<Int?>): Int {
        if (i == s.length) return 1 // base case -> Found a valid way
        if (s[i] == '0') return 0 // all numbers are in range [1, k] and there are no leading zeros -> So numbers starting with 0 mean invalid!
        if (dp[i] != null) return dp[i] ?: -1
        var ans = 0
        var num: Long = 0
        for (j in i until s.length) {
            num = num * DECIMAL + s[j].code.toLong() - '0'.code.toLong() // num is the value of the substring s[i..j]
            if (num > k) break // num must be in range [1, k]
            ans += dfs(s, k, j + 1, dp)
            ans %= MOD
        }
        return ans.also { dp[i] = it }
    }
}

class RestoreTheArrayDP : RestoreTheArray {
    override fun numberOfArrays(s: String, k: Int): Int {
        val mod = MOD
        val n: Int = s.length
        val dp = IntArray(n + 1)
        dp[0] = 1

        // dp[i] =  count of  possible arrays for i length string
        for (i in 1..n) {
            var ans = 0
            val start = n - i // reading string from end

            // taking min because we can have maximum 9-digit number
            for (j in start until min(n, start + 9)) {
                val num = s.substring(start, j + 1)
                if (num[0] == '0') continue
                val value = num.toInt()
                ans = if (value <= k) { // if number is valid
                    (ans + dp[n - j - 1]) % mod
                } else {
                    // if current number is greater than k  , then number formed after this number
                    // also greater than k , so break loop
                    break
                }
            }
            dp[i] = ans % mod
        }

        return dp[s.length] // return answer for n len string
    }
}
