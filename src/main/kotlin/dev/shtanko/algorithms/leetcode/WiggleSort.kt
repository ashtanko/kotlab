package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.swap

interface WiggleSort {
    fun perform(nums: IntArray)
}

/**
 * Approach #1 (Sorting)
 */
class WiggleSortBruteForce : WiggleSort {
    override fun perform(nums: IntArray) {
        nums.sort()
        var i = 1
        while (i < nums.size - 1) {
            nums.swap(i, i + 1)
            i += 2
        }
    }
}

/**
 * Approach #2 (One-pass Swap)
 */
class WiggleSortOnePassSwap : WiggleSort {
    override fun perform(nums: IntArray) {
        var less = true
        for (i in 0 until nums.size - 1) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    nums.swap(i, i + 1)
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    nums.swap(i, i + 1)
                }
            }
            less = !less
        }
    }
}
