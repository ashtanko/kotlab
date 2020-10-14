package dev.shtanko.algorithms.leetcode

import kotlin.math.max

internal fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
    val n: Int = nums1.size
    val m: Int = nums2.size
    var ans = IntArray(k)
    var i = max(0, k - m)
    while (i <= k && i <= n) {
        val candidate = merge(maxArray(nums1, i)!!, maxArray(nums2, k - i)!!, k)
        if (greater(candidate!!, 0, ans, 0)) ans = candidate
        ++i
    }
    return ans
}

private fun merge(nums1: IntArray, nums2: IntArray, k: Int): IntArray? {
    val ans = IntArray(k)
    var i = 0
    var j = 0
    var r = 0
    while (r < k) {
        ans[r] = if (greater(nums1, i, nums2, j)) nums1[i++] else nums2[j++]
        ++r
    }
    return ans
}

private fun greater(nums1: IntArray, i: Int, nums2: IntArray, j: Int): Boolean {
    var i1 = i
    var j2 = j
    while (i1 < nums1.size && j2 < nums2.size && nums1[i1] == nums2[j2]) {
        i1++
        j2++
    }
    return j2 == nums2.size || i1 < nums1.size && nums1[i1] > nums2[j2]
}

private fun maxArray(nums: IntArray, startIndex: Int): IntArray? {
    val n = nums.size
    val ans = IntArray(startIndex)
    var i = 0
    var j = 0
    while (i < n) {
        while (n - i + j > startIndex && j > 0 && ans[j - 1] < nums[i]) j--
        if (j < startIndex) ans[j++] = nums[i]
        ++i
    }
    return ans
}
