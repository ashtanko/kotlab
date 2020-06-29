package dev.shtanko.algorithms.leetcode

fun Int.subtractProductAndSum(): Int {
    var n = this
    var sum = 0
    var prod = 1
    while (n > 0) {
        prod *= n % DECIMAL
        sum += n % DECIMAL
        n /= DECIMAL
    }

    return prod - sum
}
