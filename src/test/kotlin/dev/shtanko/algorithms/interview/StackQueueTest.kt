package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StackQueueTest {

    @Test
    fun `stack queue test`() {
        val queue = StackQueue<Int>()

        queue.add(1)
        queue.add(2)
        queue.add(3)
        queue.add(4)

        assertTrue(1 == queue.remove())

        queue.add(5)

        assertTrue(2 == queue.remove())
        assertTrue(3 == queue.remove())
        assertTrue(4 == queue.remove())
        assertTrue(5 == queue.remove())
    }
}
