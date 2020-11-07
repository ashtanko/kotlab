package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ListNodeTest {

    @Test
    fun `simple test`() {
        val node = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3)
            }
        }
        assertEquals("1->2->3", node.prettyPrinted())
    }

    @Test
    fun `simple test 2`() {
        val node = ListNode(1)
        assertEquals("1", node.prettyPrinted())
    }

    @Test
    fun `simple test 3`() {
        val root = ListNode(0)
        var ptr: ListNode? = root
        for (i in 1 until 20) {
            ptr?.next = ListNode(i)
            ptr = ptr?.next
        }
        root.next?.prettyPrint()
    }
}
