package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.Collections

//  Missing Ranges
class MissingRanges {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String>? {
        val n = nums.size
        if (n == 0) {
            return Collections.singletonList(formatRange(lower, upper))
        }
        val missingRanges: MutableList<String> = ArrayList()

        // Edge case 1) Missing ranges at the beginning
        if (nums[0] > lower) {
            missingRanges.add(formatRange(lower, nums[0] - 1))
        }

        // Missing ranges between array elements
        for (i in 1 until n) {
            if (nums[i] - nums[i - 1] > 1) {
                missingRanges.add(formatRange(nums[i - 1] + 1, nums[i] - 1))
            }
        }

        // Edge case 2) Missing ranges at the end
        if (nums[n - 1] < upper) {
            missingRanges.add(formatRange(nums[n - 1] + 1, upper))
        }
        return missingRanges
    }

    // formats range in the requested format
    private fun formatRange(lower: Int, upper: Int): String {
        return if (lower == upper) {
            lower.toString()
        } else {
            "$lower->$upper"
        }
    }
}
