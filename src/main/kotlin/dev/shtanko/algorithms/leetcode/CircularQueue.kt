/*
 * Copyright 2021 Alexey Shtanko
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

class CircularQueue(val size: Int) {

    var first: Node? = null

    fun enQueue(value: Int): Boolean {

        if (first == null) {
            first = Node(value)
            return true
        } else {
            return false
        }
    }

    private fun isFull() = size() > size

    private fun size(): Int {
        var count = 0
        var curr: Node? = first
        while (curr != null) {
            curr = curr.next
            count++
        }
        return count
    }

    data class Node(var value: Int, var next: Node? = null)
}
