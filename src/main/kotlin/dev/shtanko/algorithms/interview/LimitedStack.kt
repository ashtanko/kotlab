package dev.shtanko.algorithms.interview

import java.util.Stack

internal class LimitedStack {
    private val inner = Stack<Int>()

    fun push(value: Int) {
        require(!isFull())
        inner.push(value)
    }

    fun pop(): Int {
        return inner.pop()
    }

    fun isFull(): Boolean = inner.size >= 1

    fun isEmpty(): Boolean = inner.size == 0
}

class StackOfStacks {
    private val stack = Stack<LimitedStack>()

    fun push(value: Int) {
        val topStack = if (stack.size <= 0 || stack.peek().isFull()) {
            val newStack = LimitedStack()
            stack.push(newStack)
            newStack
        } else {
            stack.pop()
        }

        topStack.push(value)
    }

    fun pop(): Int {
        val topStack = stack.peek()!!
        val topValue = topStack.pop()
        if (topStack.isEmpty()) {
            stack.pop()
        }

        return topValue
    }
}
