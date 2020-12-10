package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.PriorityQueue
import kotlin.math.max

interface TaskSchedulerStrategy {
    fun perform(tasks: CharArray, n: Int): Int
}

class TaskSchedulerSimple : TaskSchedulerStrategy {

    override fun perform(tasks: CharArray, n: Int): Int {
        val counter = IntArray(ARR_SIZE)
        var max = 0
        var maxCount = 0
        for (task in tasks) {
            counter[task - 'A']++
            if (max == counter[task - 'A']) {
                maxCount++
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A']
                maxCount = 1
            }
        }

        val partCount = max - 1
        val partLength = n - maxCount.minus(1)
        val emptySlots = partCount * partLength
        val availableTasks: Int = tasks.size - max * maxCount
        val idles = max(0, emptySlots - availableTasks)

        return tasks.size + idles
    }

    companion object {
        private const val ARR_SIZE = 26
    }
}

class TaskSchedulerPriorityQueue : TaskSchedulerStrategy {
    override fun perform(tasks: CharArray, n: Int): Int {
        val map: MutableMap<Char, Int> = HashMap()
        for (i in tasks.indices) {
            map[tasks[i]] =
                map.getOrDefault(tasks[i], 0) + 1 // map key is TaskName, and value is number of times to be executed.
        }

        val q: PriorityQueue<Map.Entry<Char, Int>> =
            PriorityQueue { a, b -> if (a.value != b.value) b.value - a.value else a.key - b.key }

        q.addAll(map.entries)

        var count = 0
        while (!q.isEmpty()) {
            var k = n + 1
            val tempList: MutableList<Map.Entry<Char, Int>> = ArrayList()
            while (k > 0 && !q.isEmpty()) {
                val top: MutableMap.MutableEntry<Char, Int> =
                    q.poll() as MutableMap.MutableEntry<Char, Int> // most frequency task
                top.setValue(top.value - 1) // decrease frequency, meaning it got executed
                tempList.add(top) // collect task to add back to queue
                k--
                count++ // successfully executed task
            }
            for (e in tempList) {
                if (e.value > 0) q.add(e) // add valid tasks
            }
            if (q.isEmpty()) break
            count += k // if k > 0, then it means we need to be idle
        }
        return count
    }
}
