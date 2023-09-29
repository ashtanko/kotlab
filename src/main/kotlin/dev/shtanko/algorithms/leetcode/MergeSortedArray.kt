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
 * 88. Merge Sorted Array
 * @see <a href="https://leetcode.com/problems/merge-sorted-array">Source</a>
 */
fun interface MergeSortedArray {
    operator fun invoke(nums1: IntArray, m: Int, nums2: IntArray, n: Int)
}

class MergeSortedArrayStl : MergeSortedArray {
    override fun invoke(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var j = 0
        var i = m
        while (j < n) {
            nums1[i] = nums2[j]
            i++
            j++
        }
        nums1.sort()
    }
}

class MergeSortedArrayTwoPointer : MergeSortedArray {
    override fun invoke(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]
            } else {
                nums1[k--] = nums2[j--]
            }
        }
    }
}
