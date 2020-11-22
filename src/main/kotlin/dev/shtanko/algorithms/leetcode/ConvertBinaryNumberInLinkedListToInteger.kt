package dev.shtanko.algorithms.leetcode

// Convert Binary Number in a Linked List to Integer
interface BinaryNumberToIntStrategy {
    fun perform(head: ListNode?): Int
}

// Approach 1: Binary Representation
class BinaryNumberToIntBinary : BinaryNumberToIntStrategy {
    override fun perform(head: ListNode?): Int {
        var h: ListNode = head ?: return 0
        var num: Int = h.value
        while (h.next != null) {
            num = num * 2 + h.next!!.value
            h = h.next!!
        }
        return num
    }
}

// Approach 2: Bit Manipulation
class BinaryNumberToIntBit : BinaryNumberToIntStrategy {
    override fun perform(head: ListNode?): Int {
        var h: ListNode = head ?: return 0
        var num: Int = h.value
        while (h.next != null) {
            num = num shl 1 or h.next!!.value
            h = h.next!!
        }
        return num
    }
}
