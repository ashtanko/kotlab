package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class RangeSumBSTTest<out T : RangeSumStrategy>(private val strategy: T) {

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
    fun `simple test`(testCase: Pair<Triple<IntArray, Int, Int>, Int>) {
        val arr = testCase.first.first
        val tree: TreeNode? = null
        val root = insertLevelOrder(tree, arr)
        val actual = strategy.perform(root, testCase.first.second, testCase.first.third)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

class RangeSumBSTest : RangeSumBSTTest<RangeSumBST>(RangeSumBST())
class RangeSumRecursiveTest : RangeSumBSTTest<RangeSumRecursive>(RangeSumRecursive())
