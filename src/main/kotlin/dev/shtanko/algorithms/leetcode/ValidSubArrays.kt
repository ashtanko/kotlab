package dev.shtanko.algorithms.leetcode

import java.util.Deque
import java.util.LinkedList

// Number of Valid Subarrays
class ValidSubArrays {
    fun perform(nums: IntArray): Int {
        var res: Int = nums.size
        if (nums.size <= 1) {
            return res
        }
        val stack: Deque<Int> = LinkedList()
        stack.push(nums[0])
        for (i in 1 until nums.size) {
            val num = nums[i]
            while (!stack.isEmpty() && num < stack.peek()) {
                stack.pop()
            }
            res += stack.size
            stack.push(num)
        }
        return res
    }
}
