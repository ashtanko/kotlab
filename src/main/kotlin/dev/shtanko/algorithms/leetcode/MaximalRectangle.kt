package dev.shtanko.algorithms.leetcode

import java.util.Stack

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
fun Array<CharArray>.maximalRectangle(): Int {

    if (isEmpty()) return 0

    val row = size
    val col = this[0].size
    val heights = IntArray(col)

    for (i in 0 until col) {
        if (this[0][i] == '1') {
            heights[i] = 1
        }
    }

    var maxSquare = -1
    for (i in 1 until row) {
        maxSquare = kotlin.math.max(maxSquare, heights.maxArea())

        for (j in 0 until col) {
            if (this[i][j] == '1') {
                heights[j] = heights[j] + 1
            } else {
                heights[j] = 0
            }
        }
    }

    maxSquare = kotlin.math.max(maxSquare, heights.maxArea())
    return maxSquare
}

private fun IntArray.maxArea(): Int {
    var max = -1

    val stack = Stack<Int>()
    val len = this.size
    var i = 0
    while (i < len) {
        if (stack.isEmpty() || this[i] >= this[stack.peek()]) {
            stack.push(i++)
        } else {
            val top = stack.pop()
            val currentArea = this[top] * if (stack.isEmpty()) i else i - stack.peek() - 1
            max = kotlin.math.max(max, currentArea)
        }
    }

    while (!stack.isEmpty()) {
        val top = stack.pop()
        val current = this[top] * if (stack.isEmpty()) i else i - stack.peek() - 1
        max = kotlin.math.max(max, current)
    }

    return max
}
