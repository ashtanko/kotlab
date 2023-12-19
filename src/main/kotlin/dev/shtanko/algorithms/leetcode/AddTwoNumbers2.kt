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

import dev.shtanko.algorithms.DECIMAL
import java.util.Stack

/**
 * 445. Add Two Numbers II
 * @see <a href="https://leetcode.com/problems/add-two-numbers-ii/">Source</a>
 */
fun interface AddTwoNumbers2 {
    operator fun invoke(l1: ListNode?, l2: ListNode?): ListNode?
}

/**
 * Approach 1: Using Stack
 */
class AddTwoNumbers2Stack : AddTwoNumbers2 {
    /**
     * Adds two numbers represented as linked lists in reverse order.
     *
     * @param l1 The first linked list representing a number.
     * @param l2 The second linked list representing a number.
     * @return The linked list representing the sum of l1 and l2.
     */
    override fun invoke(l1: ListNode?, l2: ListNode?): ListNode? {
        val s1: Stack<Int> = Stack<Int>()
        val s2: Stack<Int> = Stack<Int>()
        var ll1 = l1
        var ll2 = l2
        while (ll1 != null) {
            s1.push(ll1.value)
            ll1 = ll1.next
        }
        while (ll2 != null) {
            s2.push(ll2.value)
            ll2 = ll2.next
        }

        var totalSum = 0
        var carry = 0
        var ans = ListNode()
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) totalSum += s1.pop()
            if (!s2.empty()) totalSum += s2.pop()
            ans.value = totalSum % DECIMAL
            carry = totalSum / DECIMAL
            val head = ListNode(carry)
            head.next = ans
            ans = head
            totalSum = carry
        }

        return if (carry == 0) ans.next else ans
    }
}

/**
 * Approach 2: Reverse Given Linked Lists
 */
class AddTwoNumbers2Reverse : AddTwoNumbers2 {
    /**
     * Adds two numbers represented by linked lists in reverse order.
     *
     * @param l1 The first linked list representing a number in reverse order.
     * @param l2 The second linked list representing a number in reverse order.
     * @return The sum of the two numbers as a linked list in reverse order.
     */
    override fun invoke(l1: ListNode?, l2: ListNode?): ListNode? {
        var r1: ListNode? = l1?.reverseList()
        var r2: ListNode? = l2?.reverseList()

        var totalSum = 0
        var carry = 0
        var ans = ListNode()
        while (r1 != null || r2 != null) {
            if (r1 != null) totalSum += r1.value
            if (r2 != null) totalSum += r2.value
            ans.value = totalSum % DECIMAL
            carry = totalSum / DECIMAL
            val head = ListNode(carry)
            head.next = ans
            ans = head
            totalSum = carry
            r1 = r1?.next
            r2 = r2?.next
        }

        return if (carry == 0) ans.next else ans
    }
}
