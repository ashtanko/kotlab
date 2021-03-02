/*
 * Copyright 2021 Alexey Shtanko
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
 * Find the Duplicate Number
 * @link https://leetcode.com/problems/find-the-duplicate-number/
 */
interface FindDuplicateNumber {
    fun perform(nums: IntArray): Int
}

/**
 * Time complexity : O(n lg n)
 * Space complexity : O(1) or O(n)
 */
class FindDuplicateSort : FindDuplicateNumber {
    override fun perform(nums: IntArray): Int {
        nums.sort()
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) {
                return nums[i]
            }
        }
        return 0
    }
}

/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
class FindDuplicateSet : FindDuplicateNumber {
    override fun perform(nums: IntArray): Int {
        val seen: MutableSet<Int> = HashSet()
        nums.forEach {
            if (seen.contains(it)) {
                return it
            } else {
                seen.add(it)
            }
        }
        return 0
    }
}
