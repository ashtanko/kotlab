package dev.shtanko.algorithms.codility

fun findBinaryGap(n: Int): Int {
    val binaryString = Integer.toBinaryString(n)
    var count: Int
    var bigGap = 0
    var temptCount = 0
    for (element in binaryString) {
        if (element == '0') {
            temptCount++
        } else {
            count = temptCount
            if (count > bigGap) {
                bigGap = count
            }
            temptCount = 0
        }
    }
    return bigGap
}
