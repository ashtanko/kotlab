package dev.shtanko.algorithms.leetcode

import java.util.Stack

// Implement Queue using Stacks
internal class MyQueue {

    private val addStack = Stack<Int>()
    private val delStack = Stack<Int>()
    private var front = 0

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        if (addStack.isEmpty()) {
            front = x
        }
        addStack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        return if (delStack.isNotEmpty()) {
            delStack.pop()
        } else {
            while (addStack.isNotEmpty()) {
                delStack.push(addStack.pop())
            }
            delStack.pop()
        }
    }

    /** Get the front element. */
    fun peek(): Int {
        if (delStack.isNotEmpty()) {
            return delStack.peek()
        }
        return front
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return addStack.isEmpty() && delStack.isEmpty()
    }
}
