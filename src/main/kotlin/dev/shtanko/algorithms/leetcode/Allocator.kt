/*
 * Copyright 2023 Oleksii Shtanko
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

import java.util.TreeMap

/**
 * 2502. Design Memory Allocator
 * @see <a href="https://leetcode.com/problems/design-memory-allocator">leetcode page</a>
 */
interface Malloc {
    fun allocate(size: Int, mID: Int): Int

    fun free(mID: Int): Int
}

class Allocator(n: Int) : Malloc {
    data class Node(val l: Int, val r: Int)

    // certain area of memory is allocated or not
    private var a: BooleanArray = BooleanArray(n)

    // Track all allocations for each mID
    private val mIds: Array<MutableList<Node>?> = arrayOfNulls(LIMIT)

    override fun allocate(size: Int, mID: Int): Int {
        val l = findFirstAvailable(size)
        if (l == -1) return -1
        // find the list of memories allocated for this mID
        if (mIds[mID] == null) mIds[mID] = ArrayList() // if new, create the empty memList for this mID
        mIds[mID]?.add(Node(l, l + size)) // append to memList allocated to this mID

        // allocate memory
        var i = l
        val r = l + size
        while (i < r) {
            a[i] = true
            i++
        }
        return l
    }

    override fun free(mID: Int): Int {
        var size = 0
        // free all memory allocated to this mID
        for ((l, r) in mIds[mID] ?: return 0) {
            size += r - l
            for (i in l until r) a[i] = false // free memory
        }
        mIds[mID]?.clear() // this mID is gone
        return size
    }

    private fun findFirstAvailable(size: Int): Int {
        var i = 0
        while (i <= a.size - size) {
            var j = i
            val r = i + size
            while (j < r) {
                if (a[j]) {
                    i = -1
                    break
                } // true is allocated, so can't be used, we go to next section
                j++
            }
            i = if (i == -1) j + 1 else return i
        }
        return -1
    }

    companion object {
        private const val LIMIT = 1001
    }
}

class TAllocator(n: Int) : Malloc {
    private val memory: MutableMap<Int, TreeMap<Int, Int>> = HashMap()
    private val ranges = TreeMap<Int, Int>()

    init {
        ranges[0] = n - 1 // address start from 0
        memory[0] = ranges // 0 means free block
    }

    override fun allocate(size: Int, mID: Int): Int {
        var addr = -1
        val availableRange = intArrayOf(-1, -1)
        for ((startAdd, endAdd) in memory[0] ?: emptyMap()) {
            if (endAdd - startAdd + 1 >= size) {
                addr = startAdd
                availableRange[0] = startAdd
                availableRange[1] = endAdd
                break
            }
        }
        if (addr != -1) {
            memory.computeIfAbsent(mID) { _: Int? -> TreeMap() }[availableRange[0]] = availableRange[0] + size - 1
            memory[0]?.remove(availableRange[0])
            if (availableRange[1] - availableRange[0] + 1 > size) {
                memory[0]!![availableRange[0] + size] = availableRange[1]
            }
        }
        mergeRanges(mID)
        return addr
    }

    override fun free(mID: Int): Int {
        var cnt = 0
        val freeRanges = memory[mID]
        if (freeRanges != null) {
            for ((startAdd, endAdd) in freeRanges) {
                cnt += endAdd - startAdd + 1
                memory[0]!![startAdd] = endAdd
            }
        }
        memory.remove(mID)
        mergeRanges(0)
        return cnt
    }

    private fun mergeRanges(mID: Int) {
        val curRanges = memory[mID]
        val mergedRanges = TreeMap<Int, Int>()
        val lastRange = intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE)
        if (curRanges != null) {
            for ((startAdd, endAdd) in curRanges) {
                if (startAdd - 1 == lastRange[1]) {
                    lastRange[1] = endAdd
                } else {
                    if (lastRange[0] != Int.MIN_VALUE) {
                        mergedRanges[lastRange[0]] = lastRange[1]
                    }
                    lastRange[0] = startAdd
                    lastRange[1] = endAdd
                }
            }
        }
        if (lastRange[0] != Int.MIN_VALUE) {
            mergedRanges[lastRange[0]] = lastRange[1]
        }
        memory[mID] = mergedRanges
    }
}
