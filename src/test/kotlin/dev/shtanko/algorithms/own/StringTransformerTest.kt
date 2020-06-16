package dev.shtanko.algorithms.own

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringTransformerTest {

    private val ringBuffer: RingBuffer by lazy {
        RingBuffer()
    }
    private val transformer: StringTransformer by lazy {
        StringTransformer(ringBuffer)
    }

    @Test
    fun `empty string test`() {
        val actual = transformer.transform("").size
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun `short string test`() {
        val string = "{\"ev\":\"one\"}"
        val actual = transformer.transform(string).first()
        val expected = byteArrayOf(1, -128, 123, 34, 101, 118, 34, 58, 34, 111, 110, 101, 34, 125)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `one full chunk and half test`() {
        val string = "{\"ev\":\"Lorem Ipsum\"}"
        val actual = transformer.transform(string)
        val expected = Pair(0.toByte(), 1.toByte())
        val first = actual.first()[0]
        val last = actual.last()[0]
        val actualResult = Pair(first, last)
        assertEquals(expected, actualResult)
    }

    @Test
    fun `two full chunks and half test`() {
        val string = "{\"ev\":\"\"Lorem ipsum dolor sit amet.\"}"
        val actual = transformer.transform(string)
        val expected = Triple(0.toByte(), 0.toByte(), 1.toByte())
        val first = actual.first()[0]
        val second = actual[1][0]
        val last = actual.last()[0]
        val actualResult = Triple(first, second, last)
        assertEquals(expected, actualResult)
    }

    @Test
    fun `big string test`() {
        val string =
            "{\"ev\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"}"
        val actual = transformer.transform(string)
        val last = actual.last()[0]
        val expected = 1.toByte()
        assertEquals(expected, last)
        println(actual.map { it.toList() })
    }

    @Test
    fun `two one chunked transformed strings test`() {
        val firstString = "{\"ev\":\"one\"}"
        val secondString = "{\"ev\":\"two\"}"
        val firstTransformed = transformer.transform(firstString)
        val secondTransformed = transformer.transform(secondString)

        val firstId = firstTransformed.first()[1]
        val secondId = secondTransformed.first()[1]
        val expected = Pair((-128).toByte(), (-127).toByte())
        val actual = Pair(firstId, secondId)
        assertEquals(expected, actual)
    }

    @Test
    fun `one lap transformed strings test`() {
        val string = "{\"ev\":\"one\"}"
        val ids = mutableListOf<Byte>()
        for (i in 0 until 256) {
            val chunks = transformer.transform(string)
            ids.add(chunks[0][1])
        }
        val expected = Pair((-128).toByte(), 127.toByte())
        val actual = Pair(ids.first(), ids.last())
        assertEquals(expected, actual)
    }
}
