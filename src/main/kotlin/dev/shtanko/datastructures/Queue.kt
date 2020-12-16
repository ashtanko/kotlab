/*
 * Copyright 2020 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.datastructures

/**
 * @link https://www.geeksforgeeks.org/queue-data-structure/
 * A Queue is a linear structure which follows a particular order in which the operations are performed.
 * The order is First In First Out (FIFO). A good example of a queue is any queue of consumers for
 * a resource where the consumer that came first is served first.
 */
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
