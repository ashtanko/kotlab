/*
 * Copyright 2023 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

/**
 * 725. Split Linked List in Parts
 * @see <a href="https://leetcode.com/problems/split-linked-list-in-parts">Source</a>
 */
fun interface SplitLinkedListInParts {
    operator fun invoke(head: NullableListNode?, k: Int): Array<NullableListNode?>
}

/**
 * Approach #1: Create New Lists
 */
class SplitLinkedListInPartsCopy : SplitLinkedListInParts {
    override fun invoke(head: NullableListNode?, k: Int): Array<NullableListNode?> {
        var cur: NullableListNode? = head
        var n = 0
        while (cur != null) {
            cur = cur.next
            n++
        }

        val width = n / k
        val rem = n % k

        val ans = arrayOfNulls<NullableListNode>(k)
        cur = head
        for (i in 0 until k) {
            val h = NullableListNode(0)
            var write: NullableListNode? = h
            for (j in 0 until width + if (i < rem) 1 else 0) {
                write?.next = cur?.value?.let { NullableListNode(it) }
                write = write?.next
                if (cur != null) cur = cur.next
            }
            ans[i] = h.next
        }
        return ans
    }
}

/**
 * Approach #2: Split Input List
 */
class SplitLinkedListInPartsInput : SplitLinkedListInParts {
    override fun invoke(head: NullableListNode?, k: Int): Array<NullableListNode?> {
        var cur: NullableListNode? = head
        var n = 0
        while (cur != null) {
            cur = cur.next
            n++
        }

        val width = n / k
        val rem = n % k

        val ans = arrayOfNulls<NullableListNode>(k)
        cur = head
        for (i in 0 until k) {
            val h = cur
            for (j in 0 until width + (if (i < rem) 1 else 0) - 1) {
                if (cur != null) cur = cur.next
            }
            if (cur != null) {
                val prev: NullableListNode = cur
                cur = cur.next
                prev.next = null
            }
            ans[i] = h
        }
        return ans
    }
}
