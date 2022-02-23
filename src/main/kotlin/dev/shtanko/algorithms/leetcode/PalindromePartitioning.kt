/*
 * Copyright 2022 Alexey Shtanko
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
 * 131. Palindrome Partitioning
 * @link https://leetcode.com/problems/palindrome-partitioning/
 */
interface PalindromePartitioning {
    fun perform(s: String): List<List<String>>
}

/**
 * Approach 1: Backtracking
 */
class PPBacktracking : PalindromePartitioning {
    override fun perform(s: String): List<List<String>> {
        val result: MutableList<List<String>> = ArrayList()
        dfs(0, result, ArrayList(), s)
        return result
    }

    fun dfs(start: Int, result: MutableList<List<String>>, currentList: MutableList<String>, s: String) {
        if (start >= s.length) result.add(ArrayList(currentList))
        for (end in start until s.length) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1))
                dfs(end + 1, result, currentList, s)
                // backtrack and remove the current substring from currentList
                currentList.removeAt(currentList.size - 1)
            }
        }
    }

    private fun isPalindrome(s: String, low: Int, high: Int): Boolean {
        var l = low
        var h = high
        while (l < h) {
            if (s[l++] != s[h--]) {
                return false
            }
        }
        return true
    }
}

/**
 * Approach 2: Backtracking with Dynamic Programming
 */
class PPBacktrackingDP : PalindromePartitioning {
    override fun perform(s: String): List<List<String>> {
        val len: Int = s.length
        val dp = Array(len) { BooleanArray(len) }
        val result: MutableList<List<String>> = ArrayList()
        dfs(result, s, 0, ArrayList(), dp)
        return result
    }

    fun dfs(
        result: MutableList<List<String>>,
        s: String,
        start: Int,
        currentList: MutableList<String>,
        dp: Array<BooleanArray>
    ) {
        if (start >= s.length) result.add(ArrayList(currentList))
        for (end in start until s.length) {
            if (s[start] == s[end] && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true
                currentList.add(s.substring(start, end + 1))
                dfs(result, s, end + 1, currentList, dp)
                currentList.removeAt(currentList.size - 1)
            }
        }
    }
}
