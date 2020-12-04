package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.second
import dev.shtanko.algorithms.leetcode.HighFiveStrategy.Companion.CAPACITY
import dev.shtanko.algorithms.leetcode.HighFiveStrategy.Companion.SIZE
import java.util.ArrayList
import java.util.Arrays
import java.util.PriorityQueue
import java.util.TreeMap

interface HighFiveStrategy {

    companion object {
        const val CAPACITY = 5
        const val SIZE = 2
    }

    fun perform(items: Array<IntArray>): Array<IntArray>
}

class HighFivePriorityQueue : HighFiveStrategy {

    override fun perform(items: Array<IntArray>): Array<IntArray> {
        val map: TreeMap<Int, PriorityQueue<Int>> = TreeMap<Int, PriorityQueue<Int>>()

        for (item in items) {
            val id = item.first()
            val score = item.second()
            if (!map.containsKey(id)) {
                val pq: PriorityQueue<Int> = PriorityQueue<Int>(CAPACITY)
                pq.offer(score)
                map[id] = pq
            } else {
                val pq: PriorityQueue<Int> = map[id] ?: break
                pq.offer(score)
                if (pq.size > CAPACITY) {
                    pq.poll()
                }
                map[id] = pq
            }
        }

        val res = Array(map.size) { IntArray(SIZE) }

        for ((index, id) in map.keys.withIndex()) {
            res[index][0] = id
            val pq: PriorityQueue<Int> = map[id] ?: break
            var sum = 0
            val size: Int = pq.size
            while (!pq.isEmpty()) {
                sum += pq.poll()
            }
            res[index][1] = sum / size
        }

        return res
    }
}

class HighFiveSort : HighFiveStrategy {

    override fun perform(items: Array<IntArray>): Array<IntArray> {
        Arrays.sort(items) { t1, t2 ->
            // put item[id, score] with same id together
            // for each id/student, item[id, score] is ordered by score (increasing)
            if (t1[0] == t2[0]) {
                t2[1] - t1[1]
            } else t1[0] - t2[0]
        }

        val s: Int = items.size
        // The list temp helps to calculate how many students/ids are there
        val temp: MutableList<IntArray> = ArrayList()
        var i = 0
        while (i < s) {
            val id = items[i][0]
            var count = CAPACITY
            var sum = 0
            while (i < s && count-- > 0) {
                sum += items[i][1]
                i++
            }
            temp.add(intArrayOf(id, sum / CAPACITY))

            // skip scores that are not the 'HighFive' for a student
            while (i < s && items[i][0] == id) i++
        }

        val size = temp.size
        val res = Array(size) { IntArray(SIZE) }
        for (j in 0 until size) {
            res[j] = temp[j]
        }

        return res
    }
}