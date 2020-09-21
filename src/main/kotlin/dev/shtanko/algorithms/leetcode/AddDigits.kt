package dev.shtanko.algorithms.leetcode

private const val MAX = 9

fun Int.addDigits(): Int {
    var digitalRoot = 0
    var num = this
    while (num > 0) {
        digitalRoot += num % DECIMAL
        num /= DECIMAL
        if (num == 0 && digitalRoot > MAX) {
            num = digitalRoot
            digitalRoot = 0
        }
    }
    return digitalRoot
}

fun Int.addDigitsMath(): Int {
    val num = this
    if (num == 0) return 0
    if (num % MAX == 0) return MAX
    return num % MAX
}
