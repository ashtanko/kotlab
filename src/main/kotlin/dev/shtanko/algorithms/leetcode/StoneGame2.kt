/*
 * Copyright 2023 Oleksii Shtanko
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
import kotlin.math.min

/**
 * 1140. Stone Game II
 * @see <a href="https://leetcode.com/problems/stone-game-ii/">leetcode page</a>
 */
interface StoneGame2 {
    fun perform(piles: IntArray): Int
}

/**
 * Approach 1: Memoization
 */
class StoneGame2Memoization : StoneGame2 {
    override fun perform(piles: IntArray): Int {
        val dp = Array(2) {
            Array(piles.size + 1) { IntArray(piles.size + 1) }
        }
        for (p in 0..1) {
            for (i in 0..piles.size) {
                for (m in 0..piles.size) {
                    dp[p][i][m] = -1
                }
            }
        }
        return f(piles, dp, 0, 0, 1)
    }

    private fun f(piles: IntArray, dp: Array<Array<IntArray>>, p: Int, i: Int, m: Int): Int {
        if (i == piles.size) {
            return 0
        }
        if (dp[p][i][m] != -1) {
            return dp[p][i][m]
        }
        var res = if (p == 1) LIM else -1
        var s = 0
        for (x in 1..min(2 * m, piles.size - i)) {
            s += piles[i + x - 1]
            res = if (p == 0) {
                max(res, s + f(piles, dp, 1, i + x, max(m, x)))
            } else {
                min(res, f(piles, dp, 0, i + x, max(m, x)))
            }
        }
        return res.also { dp[p][i][m] = it }
    }

    companion object {
        private const val LIM = 1000000
    }
}
