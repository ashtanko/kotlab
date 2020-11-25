package dev.shtanko.algorithms.leetcode

import java.util.Stack

class BaseballGame {

    fun perform(ops: Array<String>): Int {
        val stack = Stack<Int>()
        for (op in ops) {
            when (op) {
                "+" -> {
                    val top = stack.pop()
                    val newTop = top + stack.peek()
                    stack.push(top)
                    stack.push(newTop)
                }

                "C" -> stack.pop()
                "D" -> stack.push(2 * stack.peek())
                else -> stack.push(Integer.valueOf(op))
            }
        }
        var ans = 0
        for (score in stack) ans += score
        return ans
    }
}
