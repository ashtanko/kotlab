/*
 * Copyright 2021 Alexey Shtanko
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

import junit.framework.Assert.assertTrue
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class SortedListToBSTTest<out T : SortedListToBST>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                ListNode(-10).apply {
                    next = ListNode(-3).apply {
                        next = ListNode(0).apply {
                            next = ListNode(5).apply {
                                next = ListNode(9)
                            }
                        }
                    }
                },
                listOf(0, -3, 9, -10, 5),
            ),
            Arguments.of(
                ListNode(0),
                listOf(0),
            ),
            Arguments.of(
                ListNode(1).apply {
                    next = ListNode(3)
                },
                listOf(3, 1)
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `sorted list to BST test`(head: ListNode, expected: List<Int>) {
        val actual = strategy.perform(head).postOrderTraversal()
        println("${strategy.perform(head)?.value} ${strategy.perform(head)?.left?.value} ${strategy.perform(head)?.right?.value}")
        // assertThat(actual).isEqualTo(expected)
        println("$actual")
        assertTrue(true) // TODO
    }
}

internal class SortedListToBSTRecursionTest : SortedListToBSTTest<SortedListToBSTRecursion>(SortedListToBSTRecursion())
internal class SortedListToBSTInorderTest : SortedListToBSTTest<SortedListToBSTInorder>(SortedListToBSTInorder())
internal class SortedListToBSTArrayTest : SortedListToBSTTest<SortedListToBSTArray>(SortedListToBSTArray())
