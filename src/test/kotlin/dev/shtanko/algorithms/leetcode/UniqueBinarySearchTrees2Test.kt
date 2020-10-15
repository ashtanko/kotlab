package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniqueBinarySearchTrees2Test {

    @Test
    fun `simple test`() {
        val actual = generateTrees(3)
        val ordered = actual?.map { it.levelOrderBottom() }

        val expected = listOf(
            listOf(listOf(3), listOf(2), listOf(1)),
            listOf(listOf(1, 3), listOf(2)),
            listOf(listOf(2), listOf(3), listOf(1)),
            listOf(listOf(2), listOf(1), listOf(3)),
            listOf(listOf(1), listOf(2), listOf(3))
        )
        assertEquals(expected, ordered)
    }
}
