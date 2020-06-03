package dev.shtanko.algorithms.search

class BinaryRecursiveSearch<T : Comparable<T>> : AbstractSearchStrategy<T> {
    override fun perform(arr: Array<T>, element: T): Int {
        return arr.search(0, arr.size - 1, element)
    }

    private fun Array<T>.search(low: Int, high: Int, element: T): Int {
        if (high >= low) {
            val mid = (low + high) / 2

            if (this[mid] == element) {
                return mid
            }

            if (this[mid] > element) {
                return this.search(low, mid - 1, element)
            }
            return search(mid + 1, high, element)
        }
        return -1
    }
}
