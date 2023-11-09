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

import dev.shtanko.algorithms.DECIMAL

/**
 * 2. Add Two Numbers
 * @see <a href="https://leetcode.com/problems/add-two-numbers">Source</a>
 */
fun interface AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode?
}

class AddTwoNumbersMath : AddTwoNumbers {
    override fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0) // creating a dummy list
        var curr: ListNode? = dummy // initialising a pointer
        var carry = 0 // initialising our carry with 0 initial
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null.
        // But our carry has some value in it. We will add that as well into our list
        var l10 = l1
        var l20 = l2
        while (l10 != null || l20 != null || carry == 1) {
            var sum = 0 // initialising our sum
            if (l10 != null) { // adding l1 to our sum & moving l1
                sum += l10.value
                l10 = l10.next
            }
            if (l20 != null) { // adding l2 to our sum & moving l2
                sum += l20.value
                l20 = l20.next
            }
            sum += carry // if we have carry then add it into our sum
            carry = sum / DECIMAL // if we get carry, then divide it by 10 to get the carry
            val node = ListNode(sum % DECIMAL) // the value we'll get by modulating it,
            // will become as new node so. add it to our list
            curr?.next = node // curr will point to that new node if we get
            curr = curr?.next // update the current every time
        }
        return dummy.next // return dummy.next bcz, we don't want the value we have considered in it initially
    }
}
