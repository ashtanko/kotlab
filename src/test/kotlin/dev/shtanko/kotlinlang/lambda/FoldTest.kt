package dev.shtanko.kotlinlang.lambda

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FoldTest {

    @Test
    internal fun `simple test`() {
        val items = listOf(1, 2, 3, 4, 5)
        val joinedToString: String = items.fold("Elements:", { acc, i -> "$acc $i" })
        assertEquals("Elements: 1 2 3 4 5", joinedToString)
    }

    @Test
    internal fun `simple test 2`() {
        val items = listOf(1, 2, 4, 1)
        val product = items.fold(0, Int::plus)
        assertEquals(8, product)
    }
}
