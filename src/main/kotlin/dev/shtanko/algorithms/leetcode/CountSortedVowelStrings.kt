/*
 * Copyright 2020 Alexey Shtanko
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
 * Count Sorted Vowel Strings.
 * @link https://leetcode.com/problems/count-sorted-vowel-strings
 */
interface CountSortedVowelStrings {
    fun perform(n: Int): Int
}

private const val VOWEL_COUNT = 5

/**
 * Approach 1: Brute Force Using Backtracking.
 * Time Complexity : O(n5).
 * Space Complexity: O(n).
 */
class CountSortedVowelBruteForce : CountSortedVowelStrings {
    override fun perform(n: Int): Int {
        return countVowelStringUtil(n, 1)
    }

    private fun countVowelStringUtil(n: Int, vowels: Int): Int {
        if (n == 0) return 1
        var result = 0
        for (i in vowels..VOWEL_COUNT) {
            result += countVowelStringUtil(n - 1, i)
        }
        return result
    }
}

/**
 * Approach 2: Decoding the Pattern, Using Recursion.
 * Time Complexity : O(n5).
 * Space Complexity: O(n).
 */
class CountSortedVowelRecursion : CountSortedVowelStrings {
    override fun perform(n: Int): Int {
        return countVowelStringUtil(n, VOWEL_COUNT)
    }

    private fun countVowelStringUtil(n: Int, vowels: Int): Int {
        if (n == 1) return vowels
        return if (vowels == 1) {
            1
        } else {
            countVowelStringUtil(n - 1, vowels) + countVowelStringUtil(n, vowels - 1)
        }
    }
}

/**
 * Approach 3: Using Recursion + Memoization, Top Down Dynamic Programming.
 * Time Complexity : O(n).
 * Space Complexity: O(n).
 */
class CountSortedVowelTopDynamic : CountSortedVowelStrings {
    override fun perform(n: Int): Int {
        val memo = Array(n + 1) { IntArray(VOWEL_COUNT + 1) }
        return countVowelStringUtil(n, VOWEL_COUNT, memo)
    }

    private fun countVowelStringUtil(n: Int, vowels: Int, memo: Array<IntArray>): Int {
        if (n == 1) return vowels
        if (vowels == 1) return 1
        if (memo[n][vowels] != 0) return memo[n][vowels]
        val res = countVowelStringUtil(n - 1, vowels, memo) + countVowelStringUtil(n, vowels - 1, memo)
        memo[n][vowels] = res
        return res
    }
}

class CountSortedVowelBottomUp : CountSortedVowelStrings {
    override fun perform(n: Int): Int {
        val dp = Array(n + 1) { IntArray(VOWEL_COUNT + 1) }
        for (vowels in 1..VOWEL_COUNT) dp[1][vowels] = vowels
        for (nValue in 2..n) {
            dp[nValue][1] = 1
            for (vowels in 2..VOWEL_COUNT) {
                dp[nValue][vowels] = dp[nValue][vowels - 1] + dp[nValue - 1][vowels]
            }
        }
        return dp[n][VOWEL_COUNT]
    }
}

/**
 * Approach 5: Math.
 * Time Complexity : O(1).
 * Space Complexity: O(1).
 */
class CountSortedVowelMath : CountSortedVowelStrings {
    override fun perform(n: Int): Int {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / DENOMINATOR
    }

    companion object {
        private const val DENOMINATOR = 24
    }
}
