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

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class ListNodeTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(1),
                "1"
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2).apply {
                        next = ListNode(3)
                    }
                },
                "1->2->3"
            ),
            Arguments.of(
                getRoot(),
                "0->1->2->3->4->5->6->7->8->9->10->11->12->13->14->15->16->17->18->19"
            ),
        )

        private fun getRoot(): ListNode {
            val root = ListNode(0)
            var ptr: ListNode? = root
            for (i in 1 until 20) {
                ptr?.next = ListNode(i)
                ptr = ptr?.next
            }
            return root
        }
    }

    internal class InputArgumentsProvider2 : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(
                    1
                ),
                listOf(1)
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(2)
                },
                listOf(1, 2)
            ),
            Arguments.of(
                ListNode(4).apply {
                    next = ListNode(2).apply {
                        next = ListNode(1).apply {
                            next = ListNode(3)
                        }
                    }
                },
                listOf(4, 2, 1, 3)
            ),
        )
    }

    @ArgumentsSource(InputArgumentsProvider::class)
    @ParameterizedTest
    internal fun `print list node test`(node: ListNode, expected: String) {
        val actual = node.prettyPrinted()
        assertEquals(expected, actual)
    }

    @ArgumentsSource(InputArgumentsProvider2::class)
    @ParameterizedTest
    internal fun `list node to list test`(head: ListNode, expected: List<Int>) {
        val actual = head.toList()
        assertThat(actual).containsAll(expected)
    }
}
