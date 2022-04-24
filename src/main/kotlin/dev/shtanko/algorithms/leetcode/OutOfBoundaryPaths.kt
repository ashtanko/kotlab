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
 * 576. Out of Boundary Paths
 * @link https://leetcode.com/problems/out-of-boundary-paths/
 */
interface OutOfBoundaryPaths {
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int
}

/**
 * Approach 1: Brute Force
 */
class OutOfBoundaryPathsBruteForce : OutOfBoundaryPaths {
    override fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) return 1
        if (maxMove == 0) return 0
        return findPaths(m, n, maxMove - 1, startRow - 1, startColumn) + findPaths(
            m,
            n,
            maxMove - 1,
            startRow + 1,
            startColumn
        ) + findPaths(m, n, maxMove - 1, startRow, startColumn - 1) + findPaths(
            m,
            n,
            maxMove - 1,
            startRow,
            startColumn + 1
        )
    }
}

/**
 * Approach 2: Recursion with Memoization
 */
class OutOfBoundaryPathsMemo : OutOfBoundaryPaths {
    override fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        val memo = Array(m) {
            Array(n) {
                IntArray(maxMove + 1) { -1 }
            }
        }
        return findPaths(m, n, maxMove, startRow, startColumn, memo)
    }

    private fun findPaths(
        m: Int,
        n: Int,
        maxMove: Int,
        startRow: Int,
        startColumn: Int,
        memo: Array<Array<IntArray>>
    ): Int {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) return 1
        if (maxMove == 0) return 0
        if (memo[startRow][startColumn][maxMove] >= 0) {
            return memo[startRow][startColumn][maxMove]
        }

        val l0 = findPaths(m, n, maxMove - 1, startRow + 1, startColumn, memo)
        val l1 = findPaths(m, n, maxMove - 1, startRow - 1, startColumn, memo)
        val l2 = findPaths(m, n, maxMove - 1, startRow, startColumn - 1, memo)
        val l3 = findPaths(m, n, maxMove - 1, startRow, startColumn + 1, memo)

        memo[startRow][startColumn][maxMove] = (l0 + l1 % MOD + l2 + l3 % MOD) % MOD
        return memo[startRow][startColumn][maxMove]
    }
}

class OutOfBoundaryPathsDP : OutOfBoundaryPaths {
    override fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        var dp = Array(m) { IntArray(n) }
        dp[startRow][startColumn] = 1
        var count = 0
        for (moves in 1..maxMove) {
            val temp = Array(m) { IntArray(n) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == m - 1) count = (count + dp[i][j]) % MOD
                    if (j == n - 1) count = (count + dp[i][j]) % MOD
                    if (i == 0) count = (count + dp[i][j]) % MOD
                    if (j == 0) count = (count + dp[i][j]) % MOD

                    val l = if (i > 0) dp[i - 1][j] else 0
                    val l1 = if (i < m - 1) dp[i + 1][j] else 0
                    val l2 = if (j > 0) dp[i][j - 1] else 0
                    val l3 = if (j < n - 1) dp[i][j + 1] else 0

                    temp[i][j] = ((l + l1) % MOD + (l2 + l3) % MOD) % MOD
                }
            }
            dp = temp
        }
        return count
    }
}
