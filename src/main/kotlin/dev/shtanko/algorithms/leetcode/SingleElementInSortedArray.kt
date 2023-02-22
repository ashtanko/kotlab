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
 * 540. Single Element in a Sorted Array
 * @link https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
interface SingleElementInSortedArray {
    fun singleNonDuplicate(nums: IntArray): Int
}

class SingleElementInSortedArrayBS : SingleElementInSortedArray {
    override fun singleNonDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            var mid = left.plus(right).div(2)
            if (mid % 2 == 1) {
                mid--
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid
            } else {
                left = mid + 2
            }
        }
        return nums[left]
    }
}
