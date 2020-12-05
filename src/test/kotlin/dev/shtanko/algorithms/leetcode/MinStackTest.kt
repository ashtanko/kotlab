package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinStackTest {

    @Test
    internal fun `min stack test`() {
        val minStack = MinStack()
        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        assertEquals(-3, minStack.getMin())
        minStack.pop()
        assertEquals(0, minStack.top())
        assertEquals(-2, minStack.getMin())
    }
}
