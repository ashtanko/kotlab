/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue
import kotlin.math.max

interface TaskSchedulerStrategy {
    operator fun invoke(tasks: CharArray, n: Int): Int
}

class TaskSchedulerSimple : TaskSchedulerStrategy {

    override operator fun invoke(tasks: CharArray, n: Int): Int {
        val counter = IntArray(ALPHABET_LETTERS_COUNT)
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
}

class TaskSchedulerPriorityQueue : TaskSchedulerStrategy {
    override operator fun invoke(tasks: CharArray, n: Int): Int {
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
