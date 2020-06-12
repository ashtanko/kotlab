package dev.shtanko.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PriorityQueueTest {

    @Test
    fun `empty test`() {
        val pq = PriorityQueue<Int>(3)
        assertEquals(0, pq.size)
        assertTrue(pq.isEmpty())
    }

    @Test
    fun `exception test`() {
        assertThrows<NoSuchElementException> {
            val pq = PriorityQueue<Int>(3)
            pq.peek()
        }
    }

    @Test
    fun `naive test`() {
        val pq = PriorityQueue<Int>(3)
        for (i in 10 downTo 1) {
            pq.add(i)
            assertEquals(i, pq.peek())
        }
        for (i in 1..10) {
            assertEquals(i, pq.poll())
        }
    }
}
