package dev.shtanko.algorithms.leetcode

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
internal fun Int.reversed(): Int {
    var x = this
    var result = 0

    while (x != 0) {
        val tail = x % DECIMAL
        val newResult = result * DECIMAL + tail
        if ((newResult - tail) / DECIMAL != result) {
            return 0
        }
        result = newResult
        x /= DECIMAL
    }

    return result
}
