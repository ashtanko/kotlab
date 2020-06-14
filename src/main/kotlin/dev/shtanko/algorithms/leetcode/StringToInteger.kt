package dev.shtanko.algorithms.leetcode

private const val DECIMAL = 10
fun String.atoi(): Int {
    if (this.isEmpty()) return 0 // or throw NumberFormatException()
    val str = this.trim()
    if (str.isEmpty()) return 0 // or throw NumberFormatException()
    var start = 0
    var sign = 1
    var base = 0
    if (str[start] == '-' || str[start] == '+') {
        sign = if (str[start] == '-') -1 else 1
        start++
    }

    while (start < str.length && str[start] >= '0' && str[start] <= '9') {
        if (base > Int.MAX_VALUE / DECIMAL || (base == Int.MAX_VALUE / DECIMAL && (str[start]) - '0' > Int.MAX_VALUE % DECIMAL)) {
            return if (sign > 0) {
                Int.MAX_VALUE
            } else {
                Int.MIN_VALUE
            }
        }
        base = base * DECIMAL + (str[start++] - '0')
    }

    return base * sign
}
