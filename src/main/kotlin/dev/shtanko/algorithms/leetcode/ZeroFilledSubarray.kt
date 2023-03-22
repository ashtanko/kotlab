package dev.shtanko.algorithms.leetcode

/**
 * 2348. Number of Zero-Filled Subarrays
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/
 */
interface ZeroFilledSubarray {
    fun perform(nums: IntArray): Long
}

class ZeroFilledSubarrayTwoPointers : ZeroFilledSubarray {
    override fun perform(nums: IntArray): Long {
        var res: Long = 0
        var i = 0
        var j = 0
        while (i < nums.size) {
            if (nums[i] != 0) {
                j = i + 1
            }
            res += (i - j + 1).toLong()
            ++i
        }
        return res
    }
}
