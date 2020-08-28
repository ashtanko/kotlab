package dev.shtanko.algorithms.leetcode

fun toLowerCase(str: String): String {
    val arr = str.toCharArray()
    for (i in arr.indices) {
        if (arr[i] in 'A'..'Z') {
            val local = arr[i] - 'A' + 'a'.toInt()
            arr[i] = local.toChar()
        }
    }
    return String(arr)
}
