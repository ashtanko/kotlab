package dev.shtanko.algorithms.leetcode

import java.util.Stack

// Remove All Adjacent Duplicates In String
interface RemoveAllAdjacentDuplicatesStrategy {
    fun perform(s: String): String
}

class RemoveAllAdjacentDuplicatesArray : RemoveAllAdjacentDuplicatesStrategy {
    override fun perform(s: String): String {
        var i = 0
        val n = s.length
        val res = s.toCharArray()
        var j = 0
        while (j < n) {
            res[i] = res[j]
            if (i > 0 && res[i - 1] == res[i]) {
                i -= 2
            }
            ++j
            ++i
        }
        return String(res, 0, i)
    }
}

class RemoveAllAdjacentDuplicatesStack : RemoveAllAdjacentDuplicatesStrategy {
    override fun perform(s: String): String {
        val stack: Stack<Char> = Stack()
        for (c in s) {
            if (stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
        val sb = StringBuilder()
        while (stack.isNotEmpty()) sb.append(stack.pop())
        return sb.reverse().toString()
    }
}

// Using StringBuilder
class RemoveAllAdjacentDuplicatesSB : RemoveAllAdjacentDuplicatesStrategy {
    override fun perform(s: String): String {
        val sb = StringBuilder()
        for (c in s) {
            val size = sb.length
            if (size > 0 && sb[size - 1] == c) {
                sb.deleteCharAt(size - 1)
            } else {
                sb.append(c)
            }
        }
        return sb.toString()
    }
}
