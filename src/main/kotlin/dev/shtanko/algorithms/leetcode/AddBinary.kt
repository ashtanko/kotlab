package dev.shtanko.algorithms.leetcode

fun addBinary(a: String, b: String): String {
    val sb = StringBuilder()
    var i: Int = a.length - 1
    var j: Int = b.length - 1
    var carry = 0
    while (i >= 0 || j >= 0) {
        var sum = carry
        if (j >= 0) sum += b[j--] - '0'
        if (i >= 0) sum += a[i--] - '0'
        sb.append(sum % 2)
        carry = sum / 2
    }
    if (carry != 0) sb.append(carry)
    return sb.reverse().toString()
}
