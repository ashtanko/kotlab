package dev.shtanko.kotlinlang.op

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SearchTest {

    @Test
    internal fun `binary search test`() {
        val list = listOf(4, 8, 15, 16, 23, 42)
        val expectedIndexOfArray = 3
        assertEquals(expectedIndexOfArray, list.binarySearch(16))
    }
}
