package dev.shtanko.algorithms.leetcode

import java.util.Deque
import java.util.LinkedList

fun shortestSubarray(a: IntArray, k: Int): Int {
    val n = a.size
    val p = LongArray(n + 1)
    for (i in 0 until n) p[i + 1] = p[i] + a[i].toLong()

    var ans = n + 1
    val monoq: Deque<Int> = LinkedList() // opt(y) candidates, as indices of P
    for (y in p.indices) {
        // Want opt(y) = largest x with P[x] <= P[y] - K;
        while (!monoq.isEmpty() && p[y] <= p[monoq.last]) {
            monoq.removeLast()
        }
        while (!monoq.isEmpty() && p[y] >= p[monoq.first] + k) {
            ans = ans.coerceAtMost(y - monoq.removeFirst())
        }
        monoq.addLast(y)
    }
    return if (ans < n + 1) ans else -1
}
