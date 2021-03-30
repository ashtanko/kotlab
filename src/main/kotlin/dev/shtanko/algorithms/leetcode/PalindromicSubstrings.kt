/*
 * Copyright 2021 Alexey Shtanko
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

interface PalindromicSubstrings {
    fun perform(s: String): Int
}

/**
 * Approach #1: Check All Substrings
 * Time Complexity: O(N^3)
 * Space Complexity: O(1)
 */
class PalindromicSubstringsCheckAllSubstrings : PalindromicSubstrings {
    override fun perform(s: String): Int {
        var ans = 0

        for (start in s.indices) for (end in start until s.length) ans += if (isPalindrome(
                s,
                start,
                end
            )
        ) 1 else 0

        return ans
    }

    private fun isPalindrome(str: String, start: Int, end: Int): Boolean {
        var s = start
        var e = end
        while (start < e) {
            if (str[start] != str[e]) return false
            ++s
            --e
        }
        return true
    }
}

/**
 * Approach #2: Dynamic Programming
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 */
class PalindromicSubstringsDP : PalindromicSubstrings {
    override fun perform(s: String): Int {
        val n: Int = s.length
        var ans = 0

        if (n <= 0) return 0

        val dp = Array(n) { BooleanArray(n) }

        // Base case: single letter substrings
        var k = 0
        while (k < n) {
            dp[k][k] = true
            ++k
            ++ans
        }

        // Base case: double letter substrings
        for (i in 0 until n - 1) {
            dp[i][i + 1] = s[i] == s[i + 1]
            ans += if (dp[i][i + 1]) 1 else 0
        }

        // All other cases: substrings of length 3 to n
        for (len in 3..n) {
            var i = 0
            var j = i + len - 1
            while (j < n) {
                dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
                ans += if (dp[i][j]) 1 else 0
                ++i
                ++j
            }
        }

        return ans
    }
}

/**
 * Approach #3: Expand Around Possible Centers
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */
class PalindromicSubstringsPossibleCenters : PalindromicSubstrings {
    override fun perform(s: String): Int {
        var ans = 0

        for (i in s.indices) {
            // odd-length palindromes, single character center
            ans += countPalindromesAroundCenter(s, i, i)

            // even-length palindromes, consecutive characters center
            ans += countPalindromesAroundCenter(s, i, i + 1)
        }

        return ans
    }

    private fun countPalindromesAroundCenter(ss: String, lo: Int, hi: Int): Int {
        var l = lo
        var h = hi
        var ans = 0
        while (l >= 0 && h < ss.length) {
            if (ss[l] != ss[h]) break // the first and last characters don't match!

            // expand around the center
            l--
            h++
            ans++
        }
        return ans
    }
}
