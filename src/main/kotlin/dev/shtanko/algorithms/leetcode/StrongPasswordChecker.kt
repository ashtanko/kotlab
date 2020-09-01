package dev.shtanko.algorithms.leetcode

private const val START_VALUE = 1
private const val STRONG_PASSWORD_VALUE = 6
private const val OVER_LENGTH = 20

fun strongPasswordChecker(s: String): Int {
    var res = 0
    var lowerCases = START_VALUE
    var upperCases = START_VALUE
    var digits = START_VALUE
    val carr = s.toCharArray()
    val arr = IntArray(carr.size)
    var i = 0
    while (i < arr.size) {
        if (Character.isLowerCase(carr[i])) lowerCases = 0
        if (Character.isUpperCase(carr[i])) upperCases = 0
        if (Character.isDigit(carr[i])) digits = 0
        val j = i
        while (i < carr.size && carr[i] == carr[j]) i++
        arr[j] = i - j
    }
    val totalMissing = lowerCases + upperCases + digits
    if (arr.size < STRONG_PASSWORD_VALUE) {
        res += totalMissing + 0.coerceAtLeast(STRONG_PASSWORD_VALUE - (arr.size + totalMissing))
    } else {
        val local = arr.size - OVER_LENGTH
        var overLen = local.coerceAtLeast(0)
        var leftOver = 0
        res += overLen
        for (k in 1..2) {
            i = 0
            while (i < arr.size && overLen > 0) {
                if (arr[i] < 3 || arr[i] % 3 != k - 1) {
                    i++
                    continue
                }
                arr[i] -= overLen.coerceAtMost(k)
                overLen -= k
                i++
            }
        }
        for (k in arr.indices) {
            if (arr[k] >= 3 && overLen > 0) {
                val need = arr[k] - 2
                arr[k] -= overLen
                overLen -= need
            }
            if (arr[k] >= 3) leftOver += arr[k] / 3
        }
        res += totalMissing.coerceAtLeast(leftOver)
    }
    return res
}
