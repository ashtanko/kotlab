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

/**
 * 1248. Count Number of Nice Subarrays
 * @see <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">leetcode page</a>
 */
interface NumberOfSubarrays {
    operator fun invoke(nums: IntArray, k: Int): Int
}

class NumberOfSubarraysOnePass : NumberOfSubarrays {
    override operator fun invoke(nums: IntArray, k: Int): Int {
        var res = 0
        var i = 0
        var count = 0
        val n: Int = nums.size
        var k0 = k
        for (j in 0 until n) {
            if (nums[j] % 2 == 1) {
                --k0
                count = 0
            }
            while (k0 == 0) {
                k0 += nums[i++] and 1
                ++count
            }
            res += count
        }
        return res
    }
}

class NumberOfSubarraysSlidingWindow : NumberOfSubarrays {
    override operator fun invoke(nums: IntArray, k: Int): Int {
        return atMost(nums, k) - atMost(nums, k - 1)
    }

    private fun atMost(nums: IntArray, k: Int): Int {
        var k0 = k
        var res = 0
        var i = 0
        val n = nums.size
        for (j in 0 until n) {
            k0 -= nums[j] % 2
            while (k0 < 0) {
                k0 += nums[i++] % 2
            }
            res += j - i + 1
        }
        return res
    }
}
