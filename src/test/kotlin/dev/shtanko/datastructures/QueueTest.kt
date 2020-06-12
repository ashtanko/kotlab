package dev.shtanko.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class QueueTest {

    @Test
    fun `empty test`() {
        val queue = Queue<Int>()
        assertEquals(0, queue.size)
        assertTrue(queue.isEmpty())
    }

    @Test
    fun `exception test`() {
        assertThrows<NoSuchElementException> {
            val queue = Queue<Int>()
            queue.peek()
        }
    }

    @Test
    fun `naive test`() {
        val queue = Queue<Int>()
        for (i in 0..10) {
            queue.add(i)
        }
        for (i in 0..10) {
            assertEquals(i, queue.peek())
            assertEquals(i, queue.poll())
        }
        assertEquals(0, queue.size)
    }

    @Test
    fun `naive iterator test`() {
        val queue = Queue<Int>()
        for (i in 0..10) {
            queue.add(i)
        }
        var k = 0
        for (i in queue) {
            assertEquals(i, k++)
        }
    }

    @Test
    fun `naive contains test`() {
        val queue = Queue<Int>()
        for (i in 0..10) {
            queue.add(i)
        }
        for (i in 0..10) {
            assertTrue(queue.contains(i))
        }

        assertFalse(queue.contains(100))
        assertFalse(queue.contains(101))
        assertFalse(queue.contains(103))
    }

    @Test
    fun `naive contains all test`() {
        val queue = Queue<Int>()
        for (i in 0..10) {
            queue.add(i)
        }
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 7)
        assertTrue(queue.containsAll(list))

        assertFalse(queue.containsAll(listOf(23, 42)))
    }
}
