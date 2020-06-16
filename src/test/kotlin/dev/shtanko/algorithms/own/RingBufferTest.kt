package dev.shtanko.algorithms.own

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RingBufferTest {

    private val ringBuffer: RingBuffer by lazy {
        RingBuffer()
    }

    @Test
    fun `first element test`() {
        val firstElement = ringBuffer.incrementAndGet()
        val expected = Byte.MIN_VALUE
        assertEquals(expected, firstElement)
    }

    @Test
    fun `second element test`() {
        var secondElement = ringBuffer.incrementAndGet()
        secondElement = ringBuffer.incrementAndGet()
        val expected = (-127).toByte()
        assertEquals(expected, secondElement)
    }

    @Test
    fun `last element test`() {
        var lastElement: Byte = Byte.MIN_VALUE
        for (i in 0 until 256) {
            lastElement = ringBuffer.incrementAndGet()
        }
        val expected = Byte.MAX_VALUE
        assertEquals(expected, lastElement)
    }

    @Test
    fun `one lap test`() {
        var lastElement: Byte = Byte.MIN_VALUE
        for (i in 0 until 512) {
            lastElement = ringBuffer.incrementAndGet()
        }
        val expected = Byte.MAX_VALUE
        assertEquals(expected, lastElement)
    }
}
