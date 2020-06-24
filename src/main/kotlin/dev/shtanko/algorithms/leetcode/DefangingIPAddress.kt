package dev.shtanko.algorithms.leetcode

fun String.defangIPaddrNaive(): String {
    return this.replace(".", "[.]")
}

fun String.defangIPaddr(): String {
    val sb = StringBuilder()
    for (str in this) {
        if (str == '.') {
            sb.append("[.]")
        } else {
            sb.append(str)
        }
    }
    return sb.toString()
}
