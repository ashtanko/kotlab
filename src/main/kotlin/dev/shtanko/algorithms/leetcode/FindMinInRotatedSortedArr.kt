package dev.shtanko.algorithms.leetcode

/**
 * 153. Find Minimum in Rotated Sorted Array
 * @link https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
fun findMinInRotatedSortedArr(nums: IntArray): Int {
    var start = 0
    var end = nums.size - 1
    while (start < end) {
        val mid = end.plus(start).div(2)
        if (nums[mid] >= nums[start] && nums[mid] > nums[end]) {
            start = mid + 1
        } else {
            end = mid
        }
    }
    return nums[start]
}
