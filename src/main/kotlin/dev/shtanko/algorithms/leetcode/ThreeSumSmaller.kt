package dev.shtanko.algorithms.leetcode

// 3Sum Smaller
interface ThreeSumSmallerStrategy {
    fun perform(nums: IntArray, target: Int): Int
}

class ThreeSumSmallerBinarySearch : ThreeSumSmallerStrategy {
    override fun perform(nums: IntArray, target: Int): Int {
        nums.sort()
        var sum = 0
        for (i in 0 until nums.size - 2) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i])
        }
        return sum
    }

    private fun twoSumSmaller(nums: IntArray, startIndex: Int, target: Int): Int {
        var sum = 0
        for (i in startIndex until nums.size - 1) {
            val j = binarySearch(nums, i, target - nums[i])
            sum += j - i
        }
        return sum
    }

    private fun binarySearch(nums: IntArray, startIndex: Int, target: Int): Int {
        var left = startIndex
        var right = nums.size - 1
        while (left < right) {
            val mid = (left + right + 1) / 2
            if (nums[mid] < target) {
                left = mid
            } else {
                right = mid - 1
            }
        }
        return left
    }
}

class ThreeSumSmallerTwoPointers : ThreeSumSmallerStrategy {
    override fun perform(nums: IntArray, target: Int): Int {
        nums.sort()
        var sum = 0
        for (i in 0 until nums.size - 2) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i])
        }
        return sum
    }

    private fun twoSumSmaller(nums: IntArray, startIndex: Int, target: Int): Int {
        var sum = 0
        var left = startIndex
        var right = nums.size - 1
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left
                left++
            } else {
                right--
            }
        }
        return sum
    }
}
