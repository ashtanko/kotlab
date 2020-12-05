package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class MyQueueTest {

    @Test
    internal fun `queue using stacks test`() {
        val queue = MyQueue()
        queue.push(1)
        queue.push(2)
        queue.push(3)
        assertEquals(1, queue.pop())
        assertFalse(queue.empty())
        assertEquals(2, queue.pop())
        assertFalse(queue.empty())
        assertEquals(3, queue.pop())
        assertTrue(queue.empty())
    }
}
