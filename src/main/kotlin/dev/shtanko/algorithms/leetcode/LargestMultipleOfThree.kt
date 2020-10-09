package dev.shtanko.algorithms.leetcode

private val m1 = intArrayOf(1, 4, 7, 2, 5, 8)
private val m2 = intArrayOf(2, 5, 8, 1, 4, 7)
private const val ARRAY_SIZE = 10
private const val ZERO_CHAR = '0'

fun largestMultipleOfThree(digits: IntArray): String {
    var sum = 0
    val ds = IntArray(ARRAY_SIZE)
    for (d in digits) {
        ++ds[d]
        sum += d
    }
    while (sum % 3 != 0) {
        val n = if (sum % 3 == 1) m1 else m2
        for (i in n) {
            if (ds[i] > 0) {
                --ds[i]
                sum -= i
                break
            }
        }
    }
    val sb = StringBuilder()
    for (i in ARRAY_SIZE - 1 downTo 0) {
        sb.append((ZERO_CHAR.plus(i).toString().repeat(ds[i])))
    }
    return if (sb.isNotEmpty() && sb[0] == ZERO_CHAR) "0" else sb.toString()
}
