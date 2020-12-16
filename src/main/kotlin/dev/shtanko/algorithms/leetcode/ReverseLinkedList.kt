/*
 * Copyright 2020 Alexey Shtanko
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

object ReverseLinkedList {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun reverseListIterative(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr: ListNode? = head
        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
    }

    fun reverseListRecursive(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val p: ListNode? = reverseListRecursive(head.next)
        head.next!!.next = head
        head.next = null
        return p
    }
}
