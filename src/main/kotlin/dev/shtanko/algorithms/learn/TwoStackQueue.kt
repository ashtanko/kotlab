package dev.shtanko.algorithms.learn

import java.util.Stack

class TwoStackQueue<T> : Collection<T> {

    private val stack1 = Stack<T>()
    private val stack2 = Stack<T>()

    override val size: Int
        get() = stack1.size

    override fun contains(element: T): Boolean {
        return stack1.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return stack1.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return stack1.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        return stack2.iterator()
    }

    fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        if (stack1.isEmpty()) {
            throw NoSuchElementException()
        }
        val item = stack1.peek()
        stack1.pop()
        return item
    }

    fun add(item: T) {
        while (stack1.isNotEmpty()) {
            stack2.push(stack1.pop())
        }
        stack1.push(item)
        while (stack2.isNotEmpty()) {
            stack1.push(stack2.pop())
        }
    }
}
