package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class QueuesStackTest {

    @Test
    internal fun `stack using two queues test`() {
        val stack: QueuesStack = StackTwoQueues()
        test(stack)
    }

    @Test
    internal fun `stack using two queues 2 test`() {
        val stack: QueuesStack = StackTwoQueues2()
        test(stack)
    }

    @Test
    internal fun `stack using one queue test`() {
        val stack: QueuesStack = StackOneQueue()
        test(stack)
    }

    private fun test(stack: QueuesStack) {
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals(3, stack.top())
        stack.pop()
        stack.pop()
        stack.pop()
        assertTrue(stack.empty())
    }
}
