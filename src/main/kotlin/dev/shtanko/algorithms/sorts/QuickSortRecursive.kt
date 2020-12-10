package dev.shtanko.algorithms.sorts

fun <T : Comparable<T>> List<T>.quickSort(): List<T> = when {
    size < 2 -> this
    else -> {
        val pivot = first()
        val (smaller, greater) = drop(1).partition { it <= pivot }
        smaller.quickSort() + pivot + greater.quickSort()
    }
}
