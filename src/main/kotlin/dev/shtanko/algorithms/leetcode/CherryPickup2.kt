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

import kotlin.math.max

interface CherryPickup2Strategy {
    fun perform(grid: Array<IntArray>): Int
}

class CherryPickup2DPTopDown : CherryPickup2Strategy {
    override fun perform(grid: Array<IntArray>): Int {
        val m: Int = grid.size
        val n: Int = grid[0].size
        val dpCache = Array(m) { Array(n) { IntArray(n) } }
        // initial all elements to -1 to mark unseen
        // initial all elements to -1 to mark unseen
        for (i in 0 until m) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    dpCache[i][j][k] = -1
                }
            }
        }
        return dp(0, 0, n - 1, grid, dpCache)
    }

    private fun dp(row: Int, col1: Int, col2: Int, grid: Array<IntArray>, dpCache: Array<Array<IntArray>>): Int {
        val n = grid[0].size
        val col1Predicate = colPredicate(col1, n)
        val col2Predicate = colPredicate(col2, n)
        if (col1Predicate || col2Predicate) {
            return 0
        }
        // check cache
        if (dpCache[row][col1][col2] != -1) {
            return dpCache[row][col1][col2]
        }
        // current cell
        var result = 0
        result += grid[row][col1]
        if (col1 != col2) {
            result += grid[row][col2]
        }
        // transition
        if (row != grid.size - 1) {
            var max = 0
            for (newCol1 in col1 - 1..col1 + 1) {
                for (newCol2 in col2 - 1..col2 + 1) {
                    max = max(max, dp(row + 1, newCol1, newCol2, grid, dpCache))
                }
            }
            result += max
        }
        dpCache[row][col1][col2] = result
        return result
    }

    private fun colPredicate(col: Int, size: Int) = col < 0 || col >= size
}

class CherryPickup2DPBottomUp : CherryPickup2Strategy {
    override fun perform(grid: Array<IntArray>): Int {
        val m: Int = grid.size
        val n: Int = grid[0].size
        val dp = Array(m) { Array(n) { IntArray(n) } }

        for (row in m - 1 downTo 0) {
            for (col1 in 0 until n) {
                for (col2 in 0 until n) {
                    var result = 0
                    // current cell
                    result += grid[row][col1]
                    if (col1 != col2) {
                        result += grid[row][col2]
                    }
                    // transition
                    if (row != m - 1) {
                        var max = 0
                        for (newCol1 in col1 - 1..col1 + 1) {
                            for (newCol2 in col2 - 1..col2 + 1) {
                                if (newCol1 in 0 until n && newCol2 >= 0 && newCol2 < n) {
                                    max = max(max, dp[row + 1][newCol1][newCol2])
                                }
                            }
                        }
                        result += max
                    }
                    dp[row][col1][col2] = result
                }
            }
        }
        return dp[0][0][n - 1]
    }
}
