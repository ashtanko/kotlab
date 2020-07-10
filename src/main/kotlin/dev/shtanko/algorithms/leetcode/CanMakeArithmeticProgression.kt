package dev.shtanko.algorithms.leetcode

fun IntArray.canMakeArithmeticProgression(): Boolean {
    sort()
    for (i in 2 until size) {
        if (this[i - 1] - this[i] != this[i - 2] - this[i - 1]) {
            return false
        }
    }
    return true
}

fun IntArray.canMakeArithmeticProgressionSet(): Boolean {
    val seen = HashSet<Int>()
    var mi = Int.MAX_VALUE
    var mx = Int.MIN_VALUE
    var n = size
    for (a in this) {
        mi = mi.coerceAtMost(a)
        mx = mx.coerceAtLeast(a)
        seen.add(a)
    }
    var diff = mx - mi
    val local = n - 1
    if (diff % local != 0) {
        return false
    }
    diff /= n - 1
    while (--n > 0) {
        if (!seen.contains(mi)) {
            return false
        }
        mi += diff
    }

    return true
}
