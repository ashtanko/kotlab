package dev.shtanko.algorithms.learn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.Stack

class StackTest {

    companion object {
        @JvmStatic
        fun reverseStringProvider(): List<Pair<String, String>> {
            return listOf(
                "rap" to "par",
                "car" to "rac",
                "tenet" to "tenet"
            )
        }
    }

    @Test
    fun `sort values in stack`() {
        val stack = Stack<Int>().apply {
            push(4)
            push(1)
            push(5)
            push(2)
            push(9)
            push(34)
            push(0)
        }
        assertEquals(listOf(4, 1, 5, 2, 9, 34, 0), stack.toList())
        val sorted = stack.sorted()
        assertEquals(listOf(0, 1, 2, 4, 5, 9, 34), sorted.toList())
    }

    @ParameterizedTest
    @MethodSource("reverseStringProvider")
    fun `reverse string using stack`(testCase: Pair<String, String>) {
        val str = testCase.first
        val actual = str.reversed()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
