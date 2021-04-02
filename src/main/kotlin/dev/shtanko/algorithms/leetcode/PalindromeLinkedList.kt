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

import java.util.ArrayList

interface PalindromeLinkedList {
    fun perform(head: ListNode): Boolean
}

/**
 * Approach 1: Copy into Array List and then Use Two Pointer Technique
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
class PalindromeLinkedListCopy : PalindromeLinkedList {
    override fun perform(head: ListNode): Boolean {
        val vals: MutableList<Int> = ArrayList()
        var currentNode: ListNode? = head
        while (currentNode != null) {
            vals.add(currentNode.value)
            currentNode = currentNode.next
        }
        var front = 0
        var back = vals.size - 1
        while (front < back) {
            if (vals[front] != vals[back]) {
                return false
            }
            front++
            back--
        }
        return true
    }
}

/**
 * Approach 2: Recursive (Advanced)
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
class PalindromeLinkedListRecursive : PalindromeLinkedList {

    private var frontPointer: ListNode? = null

    override fun perform(head: ListNode): Boolean {
        frontPointer = head
        return recursivelyCheck(head)
    }

    private fun recursivelyCheck(currentNode: ListNode?): Boolean {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false
            if (currentNode.value != frontPointer?.value) return false
            frontPointer = frontPointer?.next
        }
        return true
    }
}

/**
 * Approach 2: Recursive (Advanced)
 * Time complexity : O(n)
 * Space complexity : O(n)
 */
class PalindromeLinkedListReverse : PalindromeLinkedList {
    override fun perform(head: ListNode): Boolean {
        val firstHalfEnd = endOfFirstHalf(head)
        val secondHalfStart = firstHalfEnd?.next?.let { reverseList(it) }

        var p1: ListNode? = head
        var p2 = secondHalfStart
        var result = true
        while (result && p2 != null) {
            if (p1?.value != p2.value) result = false
            p1 = p1!!.next
            p2 = p2.next
        }

        firstHalfEnd?.next = secondHalfStart?.let { reverseList(it) }
        return result
    }

    private fun reverseList(head: ListNode): ListNode? {
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

    private fun endOfFirstHalf(head: ListNode?): ListNode? {
        var fast: ListNode? = head
        var slow: ListNode? = head
        while (fast?.next != null && fast.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }
        return slow
    }
}
