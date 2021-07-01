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
 * 108. Convert Sorted Array to Binary Search Tree
 * @link https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
interface SortedArrayToBST {
    fun perform(nums: IntArray): TreeNode?
}

/**
 * Approach 1: Preorder Traversal: Always Choose Left Middle Node as a Root
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
class SortedArrayToBSTPreorder : SortedArrayToBST {
    override fun perform(nums: IntArray): TreeNode? {
        return helper(nums = nums, right = nums.size - 1)
    }

    private fun helper(nums: IntArray, left: Int = 0, right: Int): TreeNode? {
        if (left > right) return null
        val leftMiddle = left.plus(right).div(2)
        val root = TreeNode(nums[leftMiddle])
        root.left = helper(nums, left, leftMiddle - 1)
        root.right = helper(nums, leftMiddle + 1, right)
        return root
    }
}
