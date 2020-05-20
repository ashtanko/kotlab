package dev.shtanko.algorithms.sorts

class BubbleSort2 : AbstractSortStrategy() {

    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (i in 0 until arr.size - 1) {
            for (j in i + 1 until arr.size) {
                if (arr[i] > arr[j]) {
                    arr.exch(i, j)
                }
            }
        }
    }
}