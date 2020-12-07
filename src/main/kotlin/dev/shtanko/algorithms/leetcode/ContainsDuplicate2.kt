package dev.shtanko.algorithms.leetcode

import java.util.TreeSet
import kotlin.math.max

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
interface ContainsDuplicate2 {
    fun perform(nums: IntArray, k: Int): Boolean
}

/**
 * Approach #1: Naive Linear Search.
 * Time complexity : O(n * min(k,n)).
 * Space complexity : O(1).
 */
class ContainsDuplicateLinear : ContainsDuplicate2 {
    override fun perform(nums: IntArray, k: Int): Boolean {
        for (i in nums.indices) {
            for (j in max(i - k, 0) until i) {
                if (nums[i] == nums[j]) return true
            }
        }
        return false
    }
}

/**
 * Approach #2: Binary Search Tree.
 * Time complexity : O(nlog(min(k,n))).
 * Space complexity : O(min(n,k)).
 */
class ContainsDuplicateBinarySearchTree : ContainsDuplicate2 {
    override fun perform(nums: IntArray, k: Int): Boolean {
        val set: MutableSet<Int> = TreeSet()
        return ContainsDuplicateDecorator(set).perform(nums, k)
    }
}

/**
 * Approach #3: Hash Table.
 *
 */
class ContainsDuplicateHash : ContainsDuplicate2 {
    override fun perform(nums: IntArray, k: Int): Boolean {
        val set: MutableSet<Int> = HashSet()
        return ContainsDuplicateDecorator(set).perform(nums, k)
    }
}

class ContainsDuplicateDecorator(private val set: MutableSet<Int>) : ContainsDuplicate2 {
    override fun perform(nums: IntArray, k: Int): Boolean {
        for (i in nums.indices) {
            if (set.contains(nums[i])) return true
            set.add(nums[i])
            if (set.size > k) {
                set.remove(nums[i - k])
            }
        }
        return false
    }
}
