package dev.shtanko.algorithms.sorts

class BubbleSort : AbstractSortStrategy() {

    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        var exchanged: Boolean

        do {
            exchanged = false
            for (i in 1 until arr.size) {
                if (arr[i] < arr[i - 1]) {
                    arr.exch(i, i - 1)
                    exchanged = true
                }
            }
        } while (exchanged)
    }

}