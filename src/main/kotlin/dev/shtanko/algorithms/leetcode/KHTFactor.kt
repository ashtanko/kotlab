package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

fun kthFactor(n: Int, k: Int): Int {
    var cnt = 0
    val list: MutableList<Int> = ArrayList()
    var i = 1
    while (i * i <= n) {
        if (n % i == 0) {
            if (i * i != n) list.add(n / i)
            if (++cnt == k) return i
        }
        i++
    }

    return if (list.size + cnt < k) -1 else list[list.size - (k - cnt)]
}
