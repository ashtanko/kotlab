package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MinStackTest {

    @Test
    fun `test push min`() {
        val stack = MinStack()
        stack.push(10)
        stack.push(11)
        stack.push(12)

        assertTrue(stack.min() == 10)

        stack.push(3)
        assertTrue(stack.min() == 3)

        stack.pop()
        assertTrue(stack.min() == 10)
    }
}
