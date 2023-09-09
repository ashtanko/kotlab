/*
 * Copyright 2021 Oleksii Shtanko
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
 * Combination Sum IV
 * @see <a href="https://leetcode.com/problems/combination-sum-iv/">leetcode page</a>
 */
fun interface CombinationSum4 {
    operator fun invoke(nums: IntArray, target: Int): Int
}

/**
 * Approach 1: Top-Down Dynamic Programming
 * Let T be the target value, and N be the number of elements in the input array.
 * Time Complexity: O(T*N)
 * Space Complexity: O(T)
 */
class CombinationSum4TopDown : CombinationSum4 {

    private val memo: MutableMap<Int, Int> = HashMap()

    override operator fun invoke(nums: IntArray, target: Int): Int {
        return combs(nums, target)
    }

    private fun combs(nums: IntArray, remain: Int): Int {
        if (remain == 0) return 1
        if (memo.containsKey(remain)) return memo.getOrDefault(remain, -1)
        var result = 0
        for (num in nums) {
            if (remain - num >= 0) result += combs(nums, remain - num)
        }
        memo[remain] = result
        return result
    }
}

/**
 * Approach 2: Bottom-Up Dynamic Programming
 * Let T be the target value, and N be the number of elements in the input array.
 * Time Complexity: O(T*N)
 * Space Complexity: O(T)
 */
class CombinationSum4BottomUp : CombinationSum4 {
    override operator fun invoke(nums: IntArray, target: Int): Int {
        // minor optimization
        val dp = IntArray(target + 1)
        dp[0] = 1

        for (combSum in 1 until target + 1) {
            for (num in nums) {
                if (combSum - num >= 0) dp[combSum] += dp[combSum - num]
            }
        }
        return dp[target]
    }
}
