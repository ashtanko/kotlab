package dev.shtanko.algorithms.leetcode

private const val MAX_ARR_SIZE = 37

fun Int.countLargestGroup(): Int {
    val map = IntArray(MAX_ARR_SIZE)
    var maxCount = 0
    var res = 0

    for (i in 1..this) {
        var num = i
        var sum = 0
        while (num > 0) {
            sum += num % DECIMAL
            num /= DECIMAL
        }
        ++map[sum]
        if (maxCount < map[sum]) {
            maxCount = map[sum]
            res = 1
        } else if (maxCount == map[sum]) {
            res++
        }
    }
    return res
}
