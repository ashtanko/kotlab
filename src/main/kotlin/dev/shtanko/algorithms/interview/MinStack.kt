package dev.shtanko.algorithms.interview

internal class MinStack {
    data class Node(
        val value: Int,
        var next: Node?,
        val subStackMin: Int
    )

    private var top: Node? = null

    fun push(value: Int) {
        val top = this.top
        this.top = Node(value, top, if (top == null || value <= top.subStackMin) value else top.subStackMin)
    }

    fun pop(): Int {
        val top = this.top!!
        this.top = top.next
        return top.value
    }

    fun min(): Int {
        return top!!.subStackMin
    }
}
