package dev.shtanko.algorithms.leetcode

fun Int.numberOfSteps(): Int {
    if (this == 0) return 0
    var result = 0
    var a = this
    var mod: Int
    while (a != 0) {
        mod = a % 2
        if (mod == 0) {
            a /= 2
        } else {
            a -= 1
        }
        result++
    }
    return result
}

fun Int.numberOfStepsBinary(): Int {
    if (this == 0) return 0
    var result = 0
    var a = this
    while (a != 0) {
        result += if (a and 1 == 0) 1 else 2
        a = a shr 1
    }
    return result - 1
}
