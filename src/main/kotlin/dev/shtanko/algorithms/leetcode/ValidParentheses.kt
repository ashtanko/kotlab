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

class ValidParentheses(private val mappings: MutableMap<Char, Char> = HashMap()) {

    init {
        mappings[')'] = '('
        mappings['}'] = '{'
        mappings[']'] = '['
    }

    fun perform(s: String): Boolean {
        // Initialize a stack to be used in the algorithm.
        val stack = Stack<Char>()

        for (character: Char in s) {
            // If the current character is a closing bracket.
            if (mappings.containsKey(character)) {
                if (stack.isEmpty() || stack.pop() != mappings[character]) return false
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(character)
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty()
    }
}
