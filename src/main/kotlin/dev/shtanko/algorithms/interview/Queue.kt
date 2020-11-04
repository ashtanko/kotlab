package dev.shtanko.algorithms.interview

import java.util.Stack

internal interface Queue<T> {
    fun add(item: T)

    fun remove(): T

    fun peek(): T

    fun isEmpty(): Boolean
}

internal class StackQueue<T> : Queue<T> {
    /**
     * Sorted from newest elements at the top to oldest elements at the bottom.
     */
    private val pushStack = Stack<T>()

    /**
     * Sorted from oldest elements at the top to newest elements at the bottom.
     */
    private val popStack = Stack<T>()

    override fun add(item: T) {
        pushStack.push(item)
    }

    override fun remove(): T {
        movePushToPop()

        return popStack.pop()
    }

    override fun peek(): T {
        movePushToPop()

        return popStack.peek()
    }

    override fun isEmpty(): Boolean = pushStack.isEmpty() && popStack.isEmpty()

    private fun movePushToPop() {
        if (popStack.isEmpty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop())
            }
        }
    }
}
