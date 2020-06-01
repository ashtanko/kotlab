package dev.shtanko.datastructures

class Stack<T> : Collection<T> {
    private var head: Node<T>? = null

    private class Node<T>(val value: T) {
        var next: Node<T>? = null
    }

    override var size: Int = 0
        private set

    override fun contains(element: T): Boolean {
        for (obj in this) {

            if (obj == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            if (!contains(element)) return false
        }
        return true
    }

    override fun isEmpty(): Boolean = size == 0

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var stackNode = head

            override fun hasNext(): Boolean = stackNode != null

            override fun next(): T {
                if (!hasNext()) throw NoSuchElementException()
                val current = stackNode!!
                stackNode = current.next
                return current.value
            }
        }
    }

    fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        return head!!.value
    }

    fun poll(): T {
        if (size == 0) throw NoSuchElementException()
        val old = head!!
        head = old.next
        size--
        return old.value
    }

    fun push(item: T) {
        val newNode = Node(item)
        newNode.next = head
        head = newNode
        size++
    }
}
