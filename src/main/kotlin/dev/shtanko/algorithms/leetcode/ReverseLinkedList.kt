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
