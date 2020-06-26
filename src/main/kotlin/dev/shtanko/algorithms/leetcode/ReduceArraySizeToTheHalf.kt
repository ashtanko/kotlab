package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue

/**
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 */
fun IntArray.minSetSize(): Int {
    val map = hashMapOf<Int, Int>()
    val list: Array<MutableList<Int>?> = Array(size + 1) { mutableListOf<Int>() }
    var steps = 0
    var res = 0

    for (num in this) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    for (num in map.keys) {
        val count = map[num]
        if (list[count!!] == null) {
            list[count] = ArrayList<Int>()
        }
        list[count]?.add(num)
    }

    for (i in size downTo 0) {
        val cur = list[i]
        if (cur == null || cur.isEmpty()) continue
        for (num in cur) {
            steps += i
            res++
            if (steps >= size / 2) {
                return res
            }
        }
    }

    return this.size
}

fun IntArray.minSetSize2(): Int {
    val map = hashMapOf<Int, Int>()
    var res = 0
    var sum = 0
    for (num in this) {
        map[num] = map.getOrDefault(num, 0) + 1
    }
    val pq = PriorityQueue<Int> { c, d -> d - c }

    for (n in map.keys) {
        pq.offer(map[n])
    }
    while (!pq.isEmpty()) {
        sum += pq.poll()
        res++
        val local = size + 1
        if (sum >= local / 2) return res
    }

    return 0
}
