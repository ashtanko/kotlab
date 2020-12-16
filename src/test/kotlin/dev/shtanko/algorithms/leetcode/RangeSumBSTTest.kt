/*
 * Copyright 2020 Alexey Shtanko
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

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class RangeSumBSTTest<out T : RangeSumStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Triple<IntArray, Int, Int>, Int>> {
            return listOf(
                Triple(intArrayOf(10, 5, 15, 3, 7, 18), 7, 15) to 32,
                Triple(intArrayOf(4, 8, 15, 16, 23, 42), 8, 23) to 15
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `range sum BST Test`(testCase: Pair<Triple<IntArray, Int, Int>, Int>) {
        val (data, expected) = testCase
        val (arr, left, right) = data
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr)
        val actual = strategy.perform(root, left, right)
        assertEquals(expected, actual)
    }
}

internal class RangeSumBSTest : RangeSumBSTTest<RangeSumBST>(RangeSumBST())
internal class RangeSumRecursiveTest : RangeSumBSTTest<RangeSumRecursive>(RangeSumRecursive())
