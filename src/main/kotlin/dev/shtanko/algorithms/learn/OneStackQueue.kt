package dev.shtanko.algorithms.learn

import java.util.Stack

class OneStackQueue<T> : Collection<T> {

    private val stack = Stack<T>()

    override val size: Int
        get() = stack.size

    override fun contains(element: T): Boolean {
        return stack.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return stack.containsAll(elements)
    }

    override fun isEmpty(): Boolean = stack.isEmpty()

    override fun iterator(): Iterator<T> {
        return stack.iterator()
    }

    fun add(item: T) {
        stack.push(item)
    }

    fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        val x = stack.peek()
        stack.pop()
        if (stack.isEmpty()) return x
        val item = peek()
        stack.push(x)
        return item
    }
}
