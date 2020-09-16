package dev.shtanko.algorithms.leetcode

private const val START_VALUE = 1
private const val STRONG_PASSWORD_VALUE = 6
private const val OVER_LENGTH = 20

enum class CharacterType {
    LOWER_CASE, UPPER_CASE, DIGIT
}

fun strongPasswordChecker(s: String): Int {
    var res = 0
    var lowerCases = START_VALUE
    var upperCases = START_VALUE
    var digits = START_VALUE
    val carr = s.toCharArray()
    val arr = IntArray(carr.size)
    var i = 0
    calculateSum(arr, i, carr) {
        when (it) {
            CharacterType.LOWER_CASE -> lowerCases = 0
            CharacterType.UPPER_CASE -> upperCases = 0
            CharacterType.DIGIT -> digits = 0
        }
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

private fun calculateSum(
    arr: IntArray,
    i: Int,
    carr: CharArray,
    action: (type: CharacterType) -> Unit
) {
    var k = i
    while (k < arr.size) {
        if (Character.isLowerCase(carr[k])) action.invoke(CharacterType.LOWER_CASE)
        if (Character.isUpperCase(carr[k])) action.invoke(CharacterType.UPPER_CASE)
        if (Character.isDigit(carr[k])) action.invoke(CharacterType.DIGIT)
        val j = k
        while (k < carr.size && carr[k] == carr[j]) k++
        arr[j] = k - j
    }
}
