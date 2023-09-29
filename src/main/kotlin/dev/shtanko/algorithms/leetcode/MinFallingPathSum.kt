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
 * 931. Minimum Falling Path Sum
 * @see <a href="https://leetcode.com/problems/minimum-falling-path-sum">Source</a>
 */
fun interface MinFallingPathSum {
    operator fun invoke(matrix: Array<IntArray>): Int
}

class MinFallingPathSumTopDown : MinFallingPathSum {
    override operator fun invoke(matrix: Array<IntArray>): Int {
        val (m, n) = listOf(matrix.size, matrix[0].size)
        fun go(i: Int, j: Int): Int {
            if (j < 0 || j == n) {
                return MOD
            }
            if (i == 0) {
                return matrix[i][j]
            }
            val a = go(i - 1, j - 1)
            val b = go(i - 1, j)
            val c = go(i - 1, j + 1)
            return matrix[i][j] + listOf(a, b, c).min()
        }

        var best = MOD
        for (j in 0 until n)
            best = min(best, go(m - 1, j))
        return best
    }
}

class MinFallingPathSumDPMemo : MinFallingPathSum {
    override operator fun invoke(matrix: Array<IntArray>): Int {
        val memo = mutableMapOf<String, Int>()
        val (m, n) = listOf(matrix.size, matrix[0].size)
        fun go(i: Int, j: Int): Int {
            if (j < 0 || j == n) {
                return MOD
            }
            if (i == 0) {
                return matrix[i][j]
            }
            val k = "$i,$j"
            if (!memo.contains(k)) {
                val a = go(i - 1, j - 1)
                val b = go(i - 1, j)
                val c = go(i - 1, j + 1)
                memo[k] = matrix[i][j] + listOf(a, b, c).min()
            }
            return memo[k] ?: 0
        }

        var best = MOD
        for (j in 0 until n)
            best = min(best, go(m - 1, j))
        return best
    }
}

class MinFallingPathSumBottomUp : MinFallingPathSum {
    override operator fun invoke(matrix: Array<IntArray>): Int {
        val (m, n) = listOf(matrix.size, matrix[0].size)
        for (i in 1 until m) {
            for (j in 0 until n) {
                val a = if (0 <= j - 1) matrix[i - 1][j - 1] else MOD
                val b = matrix[i - 1][j]
                val c = if (j + 1 < n) matrix[i - 1][j + 1] else MOD
                matrix[i][j] += listOf(a, b, c).min()
            }
        }
        return matrix[m - 1].min()
    }
}
