package dev.shtanko.datastructures

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StackTest {

    @Test
    @DisplayName("when stack is empty")
    fun `empty test`() {
        val stack = Stack<Int>()
        assertEquals(0, stack.size)
        assertTrue(stack.isEmpty())
    }

    @Test
    @DisplayName("when trying peek on empty stack")
    fun `exception test`() {
        assertThrows<NoSuchElementException> {
            val stack = Stack<Int>()
            stack.peek()
        }
    }

    @Test
    @DisplayName("when add 10 elements and poll them should be empty")
    fun `naive test`() {
        val stack = Stack<Int>()

        for (i in 0..10) {
            stack.push(i)
        }
        for (i in 10 downTo 0) {
            assertEquals(i, stack.peek())
            assertEquals(i, stack.poll())
        }
        assertEquals(0, stack.size)
    }

    @Test
    fun `test pop`() {
        val stack = Stack<Int>()
        stack.push(1)
        assertFalse(stack.isEmpty())
    }

    @Test
    fun `naive iterator test`() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }
        var k = 10
        for (i in stack) {
            assertEquals(i, k--)
        }
    }

    @Test
    fun `naive contains test`() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }

        for (i in 0..10) {
            assertTrue(stack.contains(i))
        }

        assertFalse(stack.contains(100))
        assertFalse(stack.contains(101))
        assertFalse(stack.contains(103))
    }

    @Test
    fun `naive contains all test`() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }

        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 7)
        assertTrue(stack.containsAll(list))

        assertFalse(stack.containsAll(listOf(23, 42)))
    }
}
