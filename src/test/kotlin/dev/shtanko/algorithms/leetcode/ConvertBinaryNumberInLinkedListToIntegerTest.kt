package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class BinaryNumberToIntTest<out T : BinaryNumberToIntStrategy>(
    private val strategy: T
) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(0).apply {
                        next = ListNode(1)
                    }
                },
                5
            ),
            Arguments.of(
                ListNode(0),
                0
            ),
            Arguments.of(
                ListNode(1),
                1
            ),
            Arguments.of(
                ListNode(0).apply {
                    next = ListNode(0)
                },
                0
            ),
            Arguments.of(
                getNode(),
                18880
            )
        )

        private fun getNode(): ListNode {
            var node = ListNode(0)
            val arr = listOf(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0)
            for (value in arr.reversed()) {
                val newNode = ListNode(value)
                newNode.next = node
                node = newNode
            }
            node.prettyPrint()
            return node
        }
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `convert binary number in a linked list to integer test`(head: ListNode, expected: Int) {
        val actual = strategy.perform(head)
        assertEquals(expected, actual)
    }
}

class BinaryNumberToIntBinaryTest : BinaryNumberToIntTest<BinaryNumberToIntBinary>(BinaryNumberToIntBinary())
class BinaryNumberToIntBitTest : BinaryNumberToIntTest<BinaryNumberToIntBit>(BinaryNumberToIntBit())
