package dev.shtanko.algorithms.leetcode

class DesignLinkedList {

    private val head: ListNode = ListNode(0)
    private val tail: ListNode = ListNode(0)
    private var size = 0

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(index: Int): Int {
        if (index < 0 || index >= size) return -1
        var curr: ListNode? = head
        for (i in 0..index) {
            curr = curr?.next
        }
        return curr?.value ?: -1
    }

    fun addAtHead(value: Int) {
        addAtIndex(0, value)
    }

    fun addAtTail(value: Int) {
        addAtIndex(size, value)
    }

    fun addAtIndex(index: Int, value: Int) {
        if (index > size) return
        if (index < 0) {
            addAtHead(0)
        } else {
            var curr: ListNode? = head
            for (i in 0 until index) {
                curr = curr!!.next
            }
            val newNode = ListNode(value)
            newNode.next = curr!!.next
            newNode.next?.prev = newNode
            curr.next = newNode
            newNode.prev = curr
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index > size) return
        var curr: ListNode? = head
        for (i in 0..index) {
            curr = curr?.next
        }
        curr?.next?.prev = curr?.prev
        curr?.prev?.next = curr?.next
        size--
    }

    data class ListNode(
        val value: Int,
        var next: ListNode? = null,
        var prev: ListNode? = null
    )
}
