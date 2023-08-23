/*
 * Copyright 2022 Oleksii Shtanko
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

import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import kotlin.math.max
import kotlin.math.min

/**
 * 936. Stamping The Sequence
 * @see <a href="https://leetcode.com/problems/stamping-the-sequence/">leetcode page</a>
 */
class StampingSequence {

    fun movesToStamp(stamp: String, target: String): IntArray {
        val m: Int = stamp.length
        val n: Int = target.length
        val queue: Queue<Int> = LinkedList()
        val done = BooleanArray(n)
        val ans: Stack<Int> = Stack()
        val a: MutableList<Node> = ArrayList()

        for (i in 0..n - m) {
            // For each window [i, i+M), A[i] will contain
            // info on what needs to change before we can
            // reverse stamp at this window.
            val made: MutableSet<Int> = HashSet()
            val todo: MutableSet<Int> = HashSet()
            for (j in 0 until m) {
                if (target[i + j] == stamp[j]) {
                    made.add(i + j)
                } else {
                    todo.add(i + j)
                }
            }
            a.add(Node(made, todo))

            // If we can reverse stamp at i immediately,
            // enqueue letters from this window.
            if (todo.isEmpty()) {
                ans.push(i)
                for (j in i until i + m) if (!done[j]) {
                    queue.add(j)
                    done[j] = true
                }
            }
        }

        calculateEachEnqueuedLetter(queue, a, m, n, ans, done)

        for (b in done) {
            if (!b) {
                return IntArray(0)
            }
        }

        val ret = IntArray(ans.size)
        var t = 0
        while (!ans.isEmpty()) {
            ret[t++] = ans.pop()
        }
        return ret
    }

    private fun calculateEachEnqueuedLetter(
        queue: Queue<Int>,
        a: MutableList<Node>,
        m: Int,
        n: Int,
        ans: Stack<Int>,
        done: BooleanArray,
    ) {
        // For each enqueued letter (position),
        while (!queue.isEmpty()) {
            val i: Int = queue.poll()
            // For each window that is potentially affected,
            // j: start of window
            for (j in max(0, i - m + 1)..min(n - m, i)) {
                // This window is affected
                if (a[j].todo.contains(i)) {
                    a[j].todo.remove(i)
                    if (a[j].todo.isEmpty()) {
                        ans.push(j)
                        for (o in a[j].made) {
                            if (!done[o]) {
                                queue.add(o)
                                done[o] = true
                            }
                        }
                    }
                }
            }
        }
    }

    private data class Node(var made: Set<Int>, var todo: MutableSet<Int>)
}
