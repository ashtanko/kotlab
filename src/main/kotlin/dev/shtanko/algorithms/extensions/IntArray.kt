package dev.shtanko.algorithms.extensions

/**
 * Reverse the subsections of the min array.
 */
fun IntArray.reverse(start: Int, end: Int) {
    for (i in 0 until (end - start) / 2) {
        val temp = this[i + start]
        this[i + start] = this[end - i - 1]
        this[end - i - 1] = temp
    }
}
