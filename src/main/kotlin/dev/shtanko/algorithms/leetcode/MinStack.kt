package dev.shtanko.algorithms.leetcode

import kotlin.math.min

class MinStack {

    private var head: Node? = null

    fun push(x: Int) {
        if (head == null) {
            head = Node(x, x)
        } else {
            val n = Node(x, min(x, head!!.min))
            n.next = head
            head = n
        }
    }

    fun pop() {
        if (head != null) head = head?.next
    }

    fun top(): Int {
        return if (head != null) {
            head!!.value
        } else {
            -1
        }
    }

    fun getMin(): Int {
        return if (head != null) {
            head!!.min
        } else {
            -1
        }
    }

    data class Node(val value: Int, val min: Int) {
        var next: Node? = null
    }
}
