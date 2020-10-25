package dev.shtanko.algorithms.learn

import java.util.Stack

fun <T : Comparable<T>> Stack<T>.sorted(): Stack<T> {
    val tmp = Stack<T>()
    while (this.isNotEmpty()) {
        val value = pop()
        while (tmp.isNotEmpty() && tmp.peek() > value) {
            push(tmp.pop())
        }
        tmp.push(value)
    }
    return tmp
}

internal fun String.reversed(): String {
    val stack = Stack<String>()
    val sb = StringBuilder()
    for (s in this) {
        stack.push(s.toString())
    }
    while (stack.isNotEmpty()) {
        val s = stack.pop()
        sb.append(s)
    }
    return sb.toString()
}
