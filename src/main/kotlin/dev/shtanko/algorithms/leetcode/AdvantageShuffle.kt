package dev.shtanko.algorithms.leetcode

import java.util.Deque
import java.util.LinkedList

fun advantageCount(a: IntArray, b: IntArray): IntArray {
    val sortedA: IntArray = a.clone(); sortedA.sort()
    val sortedB: IntArray = b.clone(); sortedB.sort()

    val assigned: MutableMap<Int, Deque<Int>> = HashMap()
    for (bb in b) assigned[bb] = LinkedList()

    val remaining: Deque<Int> = LinkedList()

    var j = 0
    for (aa in sortedA) {
        if (aa > sortedB[j]) {
            assigned[sortedB[j++]]?.add(aa)
        } else {
            remaining.add(aa)
        }
    }

    val ans = IntArray(b.size)
    for (i in b.indices) {
        val bDeque = assigned.getOrDefault(b[i], LinkedList())
        if (bDeque.size > 0) {
            ans[i] = bDeque.pop()
        } else {
            ans[i] = remaining.pop()
        }
    }
    return ans
}
