package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.ReverseLinkedList.ListNode
import dev.shtanko.algorithms.leetcode.ReverseLinkedList.reverseListIterative
import dev.shtanko.algorithms.leetcode.ReverseLinkedList.reverseListRecursive
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ReverseLinkedListTest {

    @Test
    internal fun `iterative test`() {
        val list = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5)
                    }
                }
            }
        }

        val reversed = reverseListIterative(list)

        val values = listOf(
            reversed?.value,
            reversed?.next?.value,
            reversed?.next?.next?.value,
            reversed?.next?.next?.next?.value,
            reversed?.next?.next?.next?.next?.value,
            reversed?.next?.next?.next?.next?.next?.value
        )
        assertEquals(listOf(5, 4, 3, 2, 1, null), values)
    }

    @Test
    internal fun `recursive test`() {
        val list = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5)
                    }
                }
            }
        }

        val reversed = reverseListRecursive(list)

        val values = listOf(
            reversed?.value,
            reversed?.next?.value,
            reversed?.next?.next?.value,
            reversed?.next?.next?.next?.value,
            reversed?.next?.next?.next?.next?.value,
            reversed?.next?.next?.next?.next?.next?.value
        )
        assertEquals(listOf(5, 4, 3, 2, 1, null), values)
    }
}
