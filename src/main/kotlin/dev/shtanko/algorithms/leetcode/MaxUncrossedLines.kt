/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import kotlin.math.max

/**
 * Uncrossed Lines
 * @see <a href="https://leetcode.com/problems/uncrossed-lines/">Source</a>
 */
fun interface UncrossedLines {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int
}

/**
 * Approach 1: Recursive Dynamic Programming
 */
class UncrossedLinesRecursiveDP : UncrossedLines {
    override fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val n1: Int = nums1.size
        val n2: Int = nums2.size

        val memo = Array(n1 + 1) { IntArray(n2 + 1) { -1 } }
        return solve(n1, n2, nums1, nums2, memo)
    }

    private fun solve(i: Int, j: Int, nums1: IntArray, nums2: IntArray, memo: Array<IntArray>): Int {
        if (i <= 0 || j <= 0) {
            return 0
        }
        if (memo[i][j] != -1) {
            return memo[i][j]
        }
        if (nums1[i - 1] == nums2[j - 1]) {
            memo[i][j] = 1 + solve(i - 1, j - 1, nums1, nums2, memo)
        } else {
            memo[i][j] = max(solve(i, j - 1, nums1, nums2, memo), solve(i - 1, j, nums1, nums2, memo))
        }
        return memo[i][j]
    }
}

/**
 * Approach 2: Iterative Dynamic Programming
 */
class UncrossedLinesIterativeDP : UncrossedLines {
    override fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val n1: Int = nums1.size
        val n2: Int = nums2.size

        val dp = Array(n1 + 1) { IntArray(n2 + 1) }

        for (i in 1..n1) {
            for (j in 1..n2) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
                }
            }
        }

        return dp[n1][n2]
    }
}
