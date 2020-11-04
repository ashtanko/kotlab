package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LimitedStackTest {

    @Test
    fun `stack of stacks test`() {
        val stacks = StackOfStacks()
        val nums = intArrayOf(1, 2, 3, 4, 5, 6)
        for (num in nums) {
            stacks.push(num)
        }

        for (num in nums.reversed()) {
            assertTrue(stacks.pop() == num)
        }
    }
}
