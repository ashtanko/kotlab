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

import java.util.ArrayList

interface FourSum {
    fun perform(nums: IntArray, target: Int): List<List<Int>>
}

/**
 * Approach 1: Two Pointers.
 * Time Complexity: O(n^{k - 1}), or O(n^3) for 4Sum. We have k - 2k−2 loops, and twoSum is O(n).
 * Space Complexity: O(n).
 */
class FourSumTwoPointers : FourSum {
    override fun perform(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        return kSum(nums, target, 0, 4)
    }

    private fun kSum(nums: IntArray, target: Int, start: Int, k: Int): List<MutableList<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()
        if (start == nums.size || nums[start] * k > target || target > nums[nums.size - 1] * k) return res
        if (k == 2) return twoSum(nums, target, start)
        for (i in start until nums.size) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (set in kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(ArrayList(listOf(nums[i])))
                    res[res.size - 1].addAll(set)
                }
            }
        }
        return res
    }

    private fun twoSum(nums: IntArray, target: Int, start: Int): List<MutableList<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()
        var lo = start
        var hi = nums.size - 1
        while (lo < hi) {
            val sum = nums[lo] + nums[hi]
            if (sum < target || lo > start && nums[lo] == nums[lo - 1]) {
                ++lo
            } else if (sum > target || hi < nums.size - 1 && nums[hi] == nums[hi + 1]) {
                --hi
            } else res.add(
                mutableListOf(nums[lo++], nums[hi--])
            )
        }
        return res
    }
}

/**
 * Time Complexity: O(n^k−1), or O(n^3) for 4Sum.
 * Space Complexity: O(n).
 */
class FourSumHashSet : FourSum {
    override fun perform(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        return kSum(nums, target, 0, 4)
    }

    private fun kSum(nums: IntArray, target: Int, start: Int, k: Int): List<List<Int>> {
        val res: MutableList<MutableList<Int>> = ArrayList()
        if (start == nums.size || nums[start] * k > target || target > nums[nums.size - 1] * k) return res
        if (k == 2) return twoSum(nums, target, start)
        for (i in start until nums.size) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (set in kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(ArrayList(listOf(nums[i])))
                    res[res.size - 1].addAll(set)
                }
            }
        }
        return res
    }

    private fun twoSum(nums: IntArray, target: Int, start: Int): List<List<Int>> {
        val res: MutableList<List<Int>> = ArrayList()
        val s: MutableSet<Int> = HashSet()
        for (i in start until nums.size) {
            if (res.isEmpty() || res[res.size - 1][1] != nums[i]) if (s.contains(target - nums[i])) res.add(
                listOf(
                    target - nums[i],
                    nums[i]
                )
            )
            s.add(nums[i])
        }
        return res
    }
}
