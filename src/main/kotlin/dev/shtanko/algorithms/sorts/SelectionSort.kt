package dev.shtanko.algorithms.sorts

class SelectionSort : AbstractSortStrategy {

    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (i in arr.indices) {
            var min = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[min]) {
                    min = j
                }
            }
            if (min != i) arr.exch(min, i)
        }
    }
}
