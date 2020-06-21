package dev.shtanko.algorithms.leetcode

import java.util.Stack

/**
 * Time O(N)
 * Space O(N)
 */
fun IntArray.finalPrices(): IntArray {
    val stack = Stack<Int>()
    for (i in 0 until size) {
        while (!stack.isEmpty() && this[stack.peek()] >= this[i]) {
            this[stack.pop()] -= this[i]
        }
        stack.push(i)
    }
    return this
}
