package dev.shtanko.algorithms.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class RemoveNthFromEndTest<out T : RemoveNthFromEnd>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4).apply {
                                next = ListNode(5)
                            }
                        }
                    }
                },
                2,
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(5)
                        }
                    }
                },
            ),
            Arguments.of(
                ListNode(1),
                1,
                null
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                1,
                ListNode(1)
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `remove nth from end test`(head: ListNode?, n: Int, expected: ListNode?) {
        val actual = strategy.perform(head, n)
        assertThat(actual).isEqualTo(expected)
    }
}

internal class RemoveNthFromEndTwoPassTest : RemoveNthFromEndTest<RemoveNthFromEndTwoPass>(RemoveNthFromEndTwoPass())
internal class RemoveNthFromEndOnePassTest : RemoveNthFromEndTest<RemoveNthFromEndOnePass>(RemoveNthFromEndOnePass())
