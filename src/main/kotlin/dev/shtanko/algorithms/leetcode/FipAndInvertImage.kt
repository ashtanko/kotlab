package dev.shtanko.algorithms.leetcode

fun flipAndInvertImage(arr: Array<IntArray>): Array<IntArray> {
    val c: Int = arr[0].size
    for (row in arr) for (i in 0 until (c + 1) / 2) {
        val tmp = row[i] xor 1
        row[i] = row[c - 1 - i] xor 1
        row[c - 1 - i] = tmp
    }

    return arr
}
