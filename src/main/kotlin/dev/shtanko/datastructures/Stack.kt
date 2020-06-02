package dev.shtanko.datastructures

/**
 * A stack is a basic data structure that can be logically thought of as a linear structure represented by a real
 * physical stack or pile, a structure where insertion and deletion of items takes place at one end called top of
 * the stack. The basic concept can be illustrated by thinking of your data set as a stack of plates or books where
 * you can only take the top item off the stack in order to remove things from it. This structure is used all
 * throughout programming. The basic implementation of a stack is also called a LIFO (Last In First Out) to demonstrate
 * the way it accesses data, since as we will see there are various variations of stack implementations.
 * There are basically three operations that can be performed on stacks. They are 1) inserting an item into
 * a stack (push). 2) deleting an item from the stack (pop). 3) displaying the contents of the stack (peek or top).
 */
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