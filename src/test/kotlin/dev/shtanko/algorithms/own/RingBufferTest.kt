package dev.shtanko.algorithms.own

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RingBufferTest {

    private val ringBuffer: RingBuffer by lazy {
        RingBuffer()
    }

    @Test
    internal fun `first element test`() {
        val firstElement = ringBuffer.incrementAndGet()
        val expected = Byte.MIN_VALUE
        assertEquals(expected, firstElement)
    }

    @Test
    internal fun `second element test`() {
        ringBuffer.incrementAndGet()
        val secondElement: Byte = ringBuffer.incrementAndGet()
        val expected = (-127).toByte()
        assertEquals(expected, secondElement)
    }

    @Test
    internal fun `last element test`() {
        var lastElement: Byte = Byte.MIN_VALUE
        for (i in 0 until 256) {
            lastElement = ringBuffer.incrementAndGet()
        }
        val expected = Byte.MAX_VALUE
        assertEquals(expected, lastElement)
    }

    @Test
    internal fun `one lap test`() {
        var lastElement: Byte = Byte.MIN_VALUE
        for (i in 0 until 512) {
            lastElement = ringBuffer.incrementAndGet()
        }
        val expected = Byte.MAX_VALUE
        assertEquals(expected, lastElement)
    }
}
