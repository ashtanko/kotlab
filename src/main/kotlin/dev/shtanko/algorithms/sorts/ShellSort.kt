package dev.shtanko.algorithms.sorts

class ShellSort : AbstractSortStrategy {

    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        var h = 1
        while (h < arr.size / DEFAULT_PART) {
            h = h * DEFAULT_PART + 1
        }

        while (h >= 1) {
            for (i in h until arr.size) {
                for (j in i downTo h step h) {
                    if (arr[j - h] < arr[j]) break
                    arr.exch(j, j - h)
                }
            }
            h /= DEFAULT_PART
        }
    }

    companion object {
        const val DEFAULT_PART = 3
    }
}
