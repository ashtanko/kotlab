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

import java.util.Arrays
import kotlin.math.max
import kotlin.math.min

/**
 * 741. Cherry Pickup
 * @link https://leetcode.com/problems/cherry-pickup/
 */
interface CherryPickup {
    fun perform(grid: Array<IntArray>): Int
}

/**
 * Approach #2: Dynamic Programming (Top Down)
 */
class CherryPickupTopDown : CherryPickup {
    private lateinit var memo: Array<Array<IntArray>>
    private lateinit var grid: Array<IntArray>
    var n = 0

    override fun perform(grid: Array<IntArray>): Int {
        this.grid = grid
        n = grid.size
        memo = Array(n) { Array(n) { IntArray(n) } }
        for (layer in memo) for (row in layer) {
            Arrays.fill(row, Int.MIN_VALUE)
        }
        return max(0, dp(0, 0, 0))
    }

    private fun dp(r1: Int, c1: Int, c2: Int): Int {
        val r2 = r1 + c1 - c2
        val helper = n == r1 || n == r2 || n == c1 || n == c2
        return if (helper || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            LIMIT
        } else if (r1 == n - 1 && c1 == n - 1) {
            grid[r1][c1]
        } else if (memo[r1][c1][c2] != Int.MIN_VALUE) {
            memo[r1][c1][c2]
        } else {
            var ans = grid[r1][c1]
            if (c1 != c2) ans += grid[r2][c2]
            ans += max(
                max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)),
                max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2))
            )
            memo[r1][c1][c2] = ans
            ans
        }
    }

    companion object {
        private const val LIMIT = -999999
    }
}

/**
 * Approach #3: Dynamic Programming (Bottom Up)
 */
class CherryPickupBottomUp : CherryPickup {
    override fun perform(grid: Array<IntArray>): Int {
        val n: Int = grid.size
        var dp = Array(n) { IntArray(n) }
        for (row in dp) Arrays.fill(row, Int.MIN_VALUE)
        dp[0][0] = grid[0][0]

        for (t in 1..2 * n - 2) {
            val dp2 = Array(n) { IntArray(n) }
            for (row in dp2) Arrays.fill(row, Int.MIN_VALUE)
            for (i in max(0, t - (n - 1))..min(n - 1, t)) {
                for (j in max(0, t - (n - 1))..min(n - 1, t)) {
                    if (grid[i][t - i] == -1 || grid[j][t - j] == -1) continue
                    var value = grid[i][t - i]
                    if (i != j) value += grid[j][t - j]
                    for (pi in i - 1..i) {
                        for (pj in j - 1..j) {
                            if (pi >= 0 && pj >= 0) {
                                dp2[i][j] = max(dp2[i][j], dp[pi][pj] + value)
                            }
                        }
                    }
                }
            }
            dp = dp2
        }
        return max(0, dp[n - 1][n - 1])
    }
}