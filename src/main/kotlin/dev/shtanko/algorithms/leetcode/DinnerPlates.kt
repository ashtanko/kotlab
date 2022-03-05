/*
 * Copyright 2022 Alexey Shtanko
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
import java.util.Stack
import java.util.TreeSet

/**
 * 1172. Dinner Plate Stacks
 */
class DinnerPlates(val capacity: Int) {

    var pq: PriorityQueue<Int> = PriorityQueue()
    var max = 0
    var map: MutableMap<Int, Stack<Int>> = HashMap()

    init {
        map[max] = Stack()
    }

    fun push(value: Int) {
        if (pq.isEmpty()) {
            if (map[max]?.size == capacity) {
                max++
            }
            map.putIfAbsent(max, Stack())
            map[max]?.push(value)
        } else {
            val index = pq.poll()
            map[index]?.push(value)
        }
    }

    fun pop(): Int {
        if (max == -1) {
            max = 0
            return -1
        }
        if (map[max]?.size == 0) {
            max--
            return pop()
        }
        val top = map[max]?.pop()
        if (map[max]?.size == 0) {
            max--
        }
        return top ?: -1
    }

    fun popAtStack(index: Int): Int {
        if (!map.containsKey(index) || map[index]?.size == 0) {
            return -1
        }
        val res = map[index]?.pop()
        pq.offer(index)
        return res ?: -1
    }
}

class DinnerPlatesTree(val capacity: Int) {
    var stacks: Stack<Stack<Int>> = Stack()
    var set = TreeSet<Int>()

    fun push(value: Int) {
        if (set.size != 0) {
            val idx = set.iterator().next()
            stacks[idx].push(value)
            if (stacks[idx].size == capacity) {
                set.remove(idx)
            }
        } else {
            if (stacks.isEmpty() || stacks.peek().size == capacity) {
                stacks.add(Stack())
                stacks.peek().add(value)
            } else {
                stacks.peek().add(value)
            }
        }
    }

    fun pop(): Int {
        if (!stacks.isEmpty()) {
            val k = stacks.peek().pop()
            while (!stacks.isEmpty() && stacks.peek().isEmpty()) {
                set.remove(stacks.size - 1)
                stacks.pop()
            }
            return k
        }
        return -1
    }

    fun popAtStack(index: Int): Int {
        if (index >= stacks.size || stacks[index].size == 0) {
            return -1
        }
        if (index == stacks.size - 1) {
            return pop()
        }
        set.add(index)
        return stacks[index].pop()
    }
}
