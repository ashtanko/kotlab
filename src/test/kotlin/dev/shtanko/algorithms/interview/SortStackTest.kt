package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Test
import java.util.Stack

class SortStackTest {

    @Test
    fun `sort stack test`() {
        val input = intArrayOf(34, 3, 31, 98, 92, 23)
        val sorted = intArrayOf(3, 23, 31, 34, 92, 98)
        val inputStack = Stack<Int>()

        for (i in input) {
            inputStack.push(i)
        }

        val sortedStack = sortStack(inputStack)

        for (i in sorted) {
            require(sortedStack.pop() == i)
        }
    }
}
