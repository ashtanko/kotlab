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

import dev.shtanko.algorithms.leetcode.KInversePairsArray.Companion.ARR_SIZE
import kotlin.math.min

/**
 * 629. K Inverse Pairs Array
 * link https://leetcode.com/problems/k-inverse-pairs-array/
 */
fun interface KInversePairsArray {
    operator fun invoke(n: Int, k: Int): Int

    companion object {
        const val ARR_SIZE = 1001
    }
}

/**
 * Approach 2: Using Recursion with Memoization
 */
class KInversePairsArrayRecursion : KInversePairsArray {
    var memo = Array(ARR_SIZE) { arrayOfNulls<Int>(ARR_SIZE) }

    override operator fun invoke(n: Int, k: Int): Int {
        if (n == 0) return 0
        if (k == 0) return 1
        if (memo[n][k] != null) return memo[n][k] ?: -1
        var inv = 0
        for (i in 0..min(k, n - 1)) {
            inv = (inv + invoke(n - 1, k - i)) % MOD
        }
        memo[n][k] = inv
        return inv
    }
}

/**
 * Approach 3: Dynamic Programming
 */
class KInversePairsArrayDP : KInversePairsArray {
    override operator fun invoke(n: Int, k: Int): Int {
        val dp = Array(n + 1) { IntArray(k + 1) }
        for (i in 1..n) {
            for (j in 0..k) {
                if (j == 0) {
                    dp[i][j] = 1
                } else {
                    for (p in 0..min(j, i - 1)) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % MOD
                    }
                }
            }
        }
        return dp[n][k]
    }
}

/**
 * Approach 4: Dynamic Programming with Cumulative Sum
 */
class CumulativeSum : KInversePairsArray {
    override operator fun invoke(n: Int, k: Int): Int {
        val dp = Array(n + 1) { IntArray(k + 1) }
        for (i in 1..n) {
            for (j in 0..k) {
                if (j == 0) {
                    dp[i][j] = 1
                } else {
                    val value = (
                        dp[i - 1][j] + MOD - if (j - i >= 0) {
                            dp[i - 1][j - i]
                        } else {
                            0
                        }
                        ) % MOD
                    dp[i][j] = (dp[i][j - 1] + value) % MOD
                }
            }
        }
        return (dp[n][k] + MOD - if (k > 0) dp[n][k - 1] else 0) % MOD
    }
}

/**
 * Approach 5: Another Optimized Dynamic Programming Approach
 */
class KInversePairsArrayOptimizedDP : KInversePairsArray {
    override operator fun invoke(n: Int, k: Int): Int {
        val dp = Array(n + 1) { IntArray(k + 1) }
        for (i in 1..n) {
            var j = 0
            while (j <= k && j <= i * (i - 1) / 2) {
                if (i == 1 && j == 0) {
                    dp[i][j] = 1
                    break
                } else if (j == 0) {
                    dp[i][j] = 1
                } else {
                    val value = (dp[i - 1][j] + MOD - if (j - i >= 0) dp[i - 1][j - i] else 0) % MOD
                    dp[i][j] = (dp[i][j - 1] + value) % MOD
                }
                j++
            }
        }
        return dp[n][k]
    }
}

/**
 * Approach 6: Once Again Memoization
 */
class KInversePairsArrayMemoization : KInversePairsArray {
    var memo = Array(ARR_SIZE) { arrayOfNulls<Int>(ARR_SIZE) }

    override operator fun invoke(n: Int, k: Int): Int {
        return (inv(n, k) + MOD - if (k > 0) inv(n, k - 1) else 0) % MOD
    }

    private fun inv(n: Int, k: Int): Int {
        if (n == 0) return 0
        if (k == 0) return 1
        if (memo[n][k] != null) return memo[n][k] ?: -1
        val value: Int = (inv(n - 1, k) + MOD - if (k - n >= 0) inv(n - 1, k - n) else 0) % MOD
        memo[n][k] = (inv(n, k - 1) + value) % MOD
        return memo[n][k] ?: -1
    }
}

/**
 * Approach 7: 1-D Dynamic Programming
 */
class KInversePairsArrayDP1D : KInversePairsArray {
    override operator fun invoke(n: Int, k: Int): Int {
        var dp = IntArray(k + 1)
        for (i in 1..n) {
            val temp = IntArray(k + 1)
            temp[0] = 1
            for (j in 1..k) {
                val value = (dp[j] + MOD - if (j - i >= 0) dp[j - i] else 0) % MOD
                temp[j] = (temp[j - 1] + value) % MOD
            }
            dp = temp
        }
        return (dp[k] + MOD - if (k > 0) dp[k - 1] else 0) % MOD
    }
}
