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

import kotlin.math.min

/**
 * Min Cost Climbing Stairs.
 * @link https://leetcode.com/problems/min-cost-climbing-stairs/
 * Time Complexity: O(N).
 * Space Complexity: O(1).
 */
interface MinCostClimbingStairs {
    fun perform(cost: IntArray): Int
}

/**
 * Recursive Approach - TLE.
 */
class MinCostClimbingStairsRecursive : MinCostClimbingStairs {
    override fun perform(cost: IntArray): Int {
        val length: Int = cost.size
        return min(recurse(cost, length - 1), recurse(cost, length - 2))
    }

    private fun recurse(cost: IntArray, i: Int): Int {
        if (i < 0) return 0
        return if (i == 0 || i == 1) cost[i] else min(recurse(cost, i - 1), recurse(cost, i - 2)) + cost[i]
    }
}

/**
 * Recursive Memoization.
 */
class MinCostClimbingStairsMemoization : MinCostClimbingStairs {
    override fun perform(cost: IntArray): Int {
        val length: Int = cost.size
        val cache = IntArray(cost.size + 1)
        return min(recurse(cost, cache, length - 1), recurse(cost, cache, length - 2))
    }

    private fun recurse(cost: IntArray, cache: IntArray, i: Int): Int {
        if (i < 0) return 0
        if (i == 0 || i == 1) {
            cache[i] = cost[i]
            return cost[i]
        }
        if (cache[i] > 0) {
            return cache[i]
        }
        cache[i] = min(recurse(cost, cache, i - 1), recurse(cost, cache, i - 2)) + cost[i]
        return cache[i]
    }
}

/**
 * Bottom Up - DP Approach.
 */
class MinCostClimbingStairsDPBottomUp : MinCostClimbingStairs {
    override fun perform(cost: IntArray): Int {
        val length: Int = cost.size
        val dp = IntArray(length + 1)
        for (i in 0 until length) {
            if (i == 0 || i == 1) dp[i] = cost[i] else dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i]
        }
        return min(dp[length - 1], dp[length - 2])
    }
}

/**
 * DP Optimized.
 */
class MinCostClimbingStairsDPOptimized : MinCostClimbingStairs {
    override fun perform(cost: IntArray): Int {
        var f1 = 0
        var f2 = 0
        for (i in cost.size - 1 downTo 0) {
            val f0 = cost[i] + min(f1, f2)
            f2 = f1
            f1 = f0
        }
        return min(f1, f2)
    }
}
