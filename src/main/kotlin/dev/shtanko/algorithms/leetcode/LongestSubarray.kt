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

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 * @see <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">leetcode page</a>
 */
interface LongestSubarray {
    fun perform(nums: IntArray): Int
}

/**
 * Sliding window with at most one 0 inside.
 */
class LongestSubarraySlidingWindow : LongestSubarray {
    override fun perform(nums: IntArray): Int {
        var i = 0
        var k = 1
        var res = 0
        var j = 0
        while (j < nums.size) {
            if (nums[j] == 0) {
                k--
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++
                }
                i++
            }
            res = max(res, j - i)
            ++j
        }
        return res
    }
}

/**
 * Sliding window that size doesn't shrink.
 */
class LongestSubarraySlidingWindow2 : LongestSubarray {
    override fun perform(nums: IntArray): Int {
        var i = 0
        var k = 1
        var j = 0
        while (j < nums.size) {
            if (nums[j] == 0) k--
            if (k < 0 && nums[i++] == 0) k++
            ++j
        }
        return j - i - 1
    }
}
