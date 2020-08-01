package dev.shtanko.algorithms.leetcode

import java.util.Stack

fun String.isValidParentheses(): Boolean {
    val stack = Stack<Char>()
    for (c in this.toCharArray()) {
        if (c == '(') {
            stack.push(')')
        } else if (c == '{') {
            stack.push('}')
        } else if (c == '[') {
            stack.push(']')
        } else if (stack.isEmpty() || stack.pop() != c) {
            return false
        }
    }
    return stack.isEmpty()
}
