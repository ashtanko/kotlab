package dev.shtanko.algorithms.leetcode

interface FindPeakElementStrategy {
    fun perform(nums: IntArray): Int
}

class FindPeakElementLinear : FindPeakElementStrategy {
    override fun perform(nums: IntArray): Int {
        return helper(nums, 0, nums.lastIndex)
    }

    private fun helper(num: IntArray, start: Int, end: Int): Int {
        return if (start == end) {
            start
        } else if (start + 1 == end) {
            if (num[start] > num[end]) start else end
        } else {
            val m = (start + end) / 2
            if (num[m] > num[m - 1] && num[m] > num[m + 1]) {
                m
            } else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {
                helper(num, start, m - 1)
            } else {
                helper(num, m + 1, end)
            }
        }
    }
}

class FindPeakElementRecursiveBinarySearch : FindPeakElementStrategy {
    override fun perform(nums: IntArray): Int {
        return search(nums, 0, nums.lastIndex)
    }

    private fun search(nums: IntArray, l: Int, r: Int): Int {
        if (l == r) return l
        val mid = (l + r) / 2
        return if (nums[mid] > nums[mid + 1]) search(nums, l, mid) else search(nums, mid + 1, r)
    }
}

class FindPeakElementIterativeBinarySearch : FindPeakElementStrategy {
    override fun perform(nums: IntArray): Int {
        var l = 0
        var r: Int = nums.lastIndex
        while (l < r) {
            val mid = (l + r) / 2
            if (nums[mid] > nums[mid + 1]) r = mid else l = mid + 1
        }
        return l
    }
}
