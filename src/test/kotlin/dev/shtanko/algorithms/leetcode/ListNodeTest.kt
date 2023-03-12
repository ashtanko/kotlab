/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import kotlin.streams.toList
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class ListNodeTest {

    internal class PrettyPrintArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1),
                "1",
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                "1->2->3",
            ),
            Arguments.of(
                getTwentyItemsList(),
                "0->1->2->3->4->5->6->7->8->9->10->11->12->13->14->15->16->17->18->19",
            ),
        )

        private fun getTwentyItemsList(): ListNode {
            val root = ListNode(0)
            var ptr: ListNode? = root
            for (i in 1 until 20) {
                ptr?.next = ListNode(i)
                ptr = ptr?.next
            }
            return root
        }
    }

    internal class InputToListArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(
                    1,
                ),
                listOf(1),
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                listOf(1, 2),
            ),
            Arguments.of(
                ListNode(4).apply {
                    next = ListNode(2).apply {
                        next = ListNode(1).apply {
                            next = ListNode(3)
                        }
                    }
                },
                listOf(4, 2, 1, 3),
            ),
        )
    }

    internal class InputToListNullableArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> =
            InputToListArgumentsProvider().provideArguments(context).toList().toMutableList().apply {
                add(
                    Arguments.of(
                        null,
                        emptyList<Int>(),
                    ),
                )
            }.stream()
    }

    class ToListArgs : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf<Int>(),
                ListNode(),
            ),
            Arguments.of(
                listOf(1),
                ListNode(1),
            ),
            Arguments.of(
                listOf(1, 2),
                ListNode(1).apply {
                    next = ListNode(2)
                },
            ),
            Arguments.of(
                listOf(1, 2, 3),
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
            ),
            Arguments.of(
                listOf(1, 2, 3, 4),
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3).apply {
                            next = ListNode(4)
                        }
                    }
                },
            ),
        )
    }

    class ReverseListArgs : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf(1, 2, 3, 4, 5, 6, 7).toListNode(),
                listOf(1, 2, 3, 4, 5, 6, 7).reversed(),
            ),
            Arguments.of(
                listOf(1).toListNode(),
                listOf(1).reversed(),
            ),
            Arguments.of(
                listOf(1, 2).toListNode(),
                listOf(1, 2).reversed(),
            ),
            Arguments.of(
                listOf<Int>().toListNode(),
                listOf<Int>().reversed(),
            ),
            Arguments.of(
                listOf(-1, -2).toListNode(),
                listOf(-1, -2).reversed(),
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(ToListArgs::class)
    internal fun `to list node test`(list: List<Int>, expected: ListNode) {
        val actual = list.toListNode().toList()
        assertThat(actual).isEqualTo(expected.toList())
    }

    @ArgumentsSource(PrettyPrintArgumentsProvider::class)
    @ParameterizedTest
    internal fun `print list node test`(node: ListNode, expected: String) {
        val actual = node.prettyPrinted()
        assertEquals(expected, actual)
    }

    @ArgumentsSource(InputToListArgumentsProvider::class)
    @ParameterizedTest
    internal fun `list node to list test`(head: ListNode, expected: List<Int>) {
        val actual = head.toList()
        assertThat(actual).containsAll(expected)
    }

    @ArgumentsSource(InputToListNullableArgumentsProvider::class)
    @ParameterizedTest
    internal fun `list node to list nullable test`(head: ListNode?, expected: List<Int>) {
        val actual = head.toListOrEmpty()
        assertThat(actual).containsAll(expected)
    }

    @ArgumentsSource(ReverseListArgs::class)
    @ParameterizedTest
    internal fun `reverse list test`(head: ListNode, expected: List<Int>) {
        val actual = head.reverseList()?.toList()
        assertThat(actual).containsAll(expected)
    }

    @Test
    internal fun `when list node is not null, should return true`() {
        val node = ListNode(1)
        assertThat(node.isNotNull()).isTrue()
    }

    @Test
    internal fun `when list node is null, should return false`() {
        val node: ListNode? = null
        assertThat(node.isNotNull()).isFalse()
    }

    @Test
    internal fun `addIfNotNull, when null, should skip`() {
        val node: ListNode? = null
        val list = ArrayList<ListNode>()
        list.addIfNotNull(node)
        assertThat(list).isEmpty()
    }

    @Test
    internal fun `addIfNotNull, when not null, should add`() {
        val node = ListNode(0)
        val list = ArrayList<ListNode>()
        list.addIfNotNull(node)
        assertThat(list).isNotEmpty()
    }
}
