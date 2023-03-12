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

data class ListNode(
    val value: Int = 0,
    var next: ListNode? = null,
) {
    fun prettyPrinted(): String {
        val sb = StringBuilder()
        var node: ListNode? = this
        while (node?.next != null) {
            sb.append("${node.value}->")
            node = node.next
        }
        if (node != null) {
            sb.append(node.value)
        } else {
            sb.append("Empty LinkedList")
        }
        return sb.toString()
    }

    fun prettyPrint() {
        println(prettyPrinted())
    }
}

fun List<Int>.toListNode(): ListNode {
    if (isEmpty()) return ListNode()
    var current = ListNode()
    var startNode = ListNode()
    for (i in indices) {
        val node = ListNode(this[i])
        if (i > 0) {
            current.next = node
        } else {
            startNode = node
        }
        current = node
    }
    return startNode
}

fun ListNode.toList(): List<Int> {
    val result = mutableListOf<Int>()
    var node: ListNode? = this
    if (next == null) {
        result.add(value)
        return result
    }
    while (node != null) {
        result.add(node.value)
        node = node.next
    }
    return result
}

fun ListNode?.toListOrEmpty(): List<Int> {
    return this?.toList() ?: emptyList()
}

fun ListNode?.isNotNull(): Boolean {
    return this != null
}

fun MutableCollection<ListNode>.addIfNotNull(node: ListNode?) {
    node?.let {
        add(it)
    }
}

fun ListNode.reverseList(): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = this
    var next: ListNode?
    while (curr != null) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}
