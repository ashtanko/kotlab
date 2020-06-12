package dev.shtanko.algorithms.leetcode

private const val TEN = 10

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
internal fun Int.reversed(): Int {
    var x = this
    var result = 0

    while (x != 0) {
        val tail = x % TEN
        val newResult = result * TEN + tail
        if ((newResult - tail) / TEN != result) {
            return 0
        }
        result = newResult
        x /= TEN
    }

    return result
}
