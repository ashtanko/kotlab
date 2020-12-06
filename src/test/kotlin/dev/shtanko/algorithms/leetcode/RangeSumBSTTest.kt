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
