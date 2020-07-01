package dev.shtanko.algorithms.leetcode

fun Pair<IntArray, IntArray>.createTargetArray(): IntArray {
    val res = ArrayList<Int>()
    for (i in second.indices) {
        res.add(second[i], first[i])
    }

    return res.toIntArray()
}

fun Pair<IntArray, IntArray>.createTargetArray2(): IntArray {
    val n = first.size
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = i
    }
    helper(a, 0, n, second, IntArray(n))
    val result = IntArray(n)
    for (i in 0 until n) {
        result[second[i]] = first[i]
    }
    return result
}

private fun helper(a: IntArray, i: Int, j: Int, index: IntArray, tmp: IntArray) {
    if (j - i <= 1) {
        return
    }
    val k = i + j ushr 1
    helper(a, i, k, index, tmp)
    helper(a, k, j, index, tmp)
    var x = i
    var y = k
    var z = 0
    var count = 0
    while (x < k && y < j) {
        while (y < j && index[a[y]] <= index[a[x]] + count) {
            ++count
            tmp[z++] = a[y++]
        }
        index[a[x]] += count
        tmp[z++] = a[x++]
    }
    while (x < k) {
        index[a[x]] += count
        tmp[z++] = a[x++]
    }
    while (y < j) {
        tmp[z++] = a[y++]
    }
    var p = i
    var q = 0
    while (p < j) {
        a[p] = tmp[q]
        ++p
        ++q
    }
}
