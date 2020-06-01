package dev.shtanko.datastructures

class Queue<T> : Collection<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

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
            var node = head

            override fun hasNext(): Boolean = node != null

            override fun next(): T {
                if (!hasNext()) throw NoSuchElementException()

                val current = node!!
                node = current.next
                return current.value
            }
        }
    }

    fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        return head?.value!!
    }

    fun poll(): T {
        if (size == 0) throw NoSuchElementException()
        val old = head!!
        head = old.next
        size--
        return old.value
    }

    fun add(item: T) {
        val newNode = Node(item)
        val tail = this.tail
        if (tail == null) {
            head = newNode
            this.tail = newNode
        } else {
            tail.next = newNode
            this.tail = newNode
        }
        size++
    }
}
