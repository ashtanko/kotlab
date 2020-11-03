package dev.shtanko.algorithms.leetcode

private const val RED = 0
private const val WHITE = 1
private const val BLUE = 2

interface SortColorsStrategy {
    fun perform(nums: IntArray)
}

class SortColorsOnePass : SortColorsStrategy {
    override fun perform(nums: IntArray) {
        var p1 = 0
        var p2 = nums.size - 1
        var index = 0
        while (index <= p2) {
            if (nums[index] == RED) {
                nums[index] = nums[p1]
                nums[p1] = RED
                p1++
            }
            if (nums[index] == BLUE) {
                nums[index] = nums[p2]
                nums[p2] = BLUE
                p2--
                index--
            }
            index++
        }
    }
}

class SortColorsTwoPass : SortColorsStrategy {
    override fun perform(nums: IntArray) {
        var red = 0
        var white = 0
        var blue = 0
        for (num in nums) {
            when (num) {
                RED -> red++
                WHITE -> white++
                BLUE -> blue++
            }
        }
        for (i in nums.indices) {
            when {
                i < red -> nums[i] = RED
                i < red + white -> nums[i] = WHITE
                else -> nums[i] = BLUE
            }
        }
    }
}
