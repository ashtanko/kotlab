package dev.shtanko.algorithms.leetcode

fun Int.isHappy(): Boolean {
    val inLoop: MutableSet<Int> = HashSet()
    var squareSum: Int
    var remain: Int
    var n = this
    while (inLoop.add(n)) {
        squareSum = 0
        while (n > 0) {
            remain = n % DECIMAL
            squareSum += remain * remain
            n /= DECIMAL
        }
        if (squareSum == 1) return true else n = squareSum
    }
    return false
}
