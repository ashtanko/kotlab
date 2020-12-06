package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DesignLinkedListTest {

    @Test
    internal fun `linked list test`() {
        val list = DesignLinkedList()
        list.addAtHead(1)
        list.addAtTail(3)
        list.addAtIndex(1, 2)
        assertEquals(2, list.get(1))
        list.deleteAtIndex(1)
        assertEquals(3, list.get(1))
    }

    @Test
    internal fun `linked list test 2`() {
        val list = DesignLinkedList()
        list.addAtHead(2)
        list.deleteAtIndex(1)
        list.addAtHead(2)
        list.addAtHead(7)
        list.addAtHead(3)
        list.addAtHead(2)
        list.addAtHead(5)
        list.addAtTail(5)
        println(list.get(5))
        list.deleteAtIndex(6)
        list.deleteAtIndex(4)
    }
}
