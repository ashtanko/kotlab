package dev.shtanko.datastructures

import dev.shtanko.algorithms.extensions.swap

/**
 * Priority queue is an abstract data type similar to regular queue or stack data structure in which each element
 * additionally has a "priority" associated with it. In a priority queue, an element with high priority is served
 * before an element with low priority. In some implementations, if two elements have the same priority, they are
 * served according to the order in which they were enqueued, while in other implementations, ordering of elements
 * with the same priority is undefined.
 */
class PriorityQueue<T>(size: Int, private val comparator: Comparator<T>? = null) : Collection<T> {

    override var size: Int = 0
        private set

    private var arr: Array<T?> = Array<Comparable<T>?>(size) { null } as Array<T?>

    fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        return arr[1]!!
    }

    fun poll(): T {
        if (size == 0) throw NoSuchElementException()
        val res = peek()
        arr.swap(1, size--)
        sink(1)
        arr[size + 1] = null
        if ((size > 0) && (size == (arr.size - 1) / SQUAD)) {
            resize()
        }
        return res
    }

    fun add(element: T) {
        if (size + 1 == arr.size) {
            resize()
        }
        arr[++size] = element
        swim(size)
    }

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
        return arr.copyOfRange(1, size + 1).map { it!! }.iterator()
    }

    private fun swim(n: Int) {
        swim(arr, n, comparator)
    }

    private fun sink(n: Int) {
        sink(arr, n, size, comparator)
    }

    private fun resize() {
        val old = arr
        arr = Array<Comparable<T>?>(size * 2) { null } as Array<T?>
        System.arraycopy(old, 0, arr, 0, size + 1)
    }

    companion object {

        private const val SQUAD = 4

        private fun <T> greater(arr: Array<T?>, i: Int, j: Int, comparator: Comparator<T>? = null): Boolean {
            return if (comparator != null) {
                comparator.compare(arr[i], arr[j]) > 0
            } else {
                val left = arr[i]!! as Comparable<T>
                left > arr[j]!!
            }
        }

        fun <T> sink(arr: Array<T?>, a: Int, size: Int, comparator: Comparator<T>? = null) {
            var k = a
            while (2 * k <= size) {
                var j = 2 * k
                if (j < size && greater(arr, j, j + 1, comparator)) j++
                if (!greater(arr, k, j, comparator)) break
                arr.swap(k, j)
                k = j
            }
        }

        fun <T> swim(arr: Array<T?>, size: Int, comparator: Comparator<T>? = null) {
            var n = size
            while (n > 1 && greater(arr, n / 2, n, comparator)) {
                arr.swap(n, n / 2)
                n /= 2
            }
        }
    }
}
