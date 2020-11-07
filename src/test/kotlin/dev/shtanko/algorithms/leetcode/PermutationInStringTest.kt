package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class PermutationInStringStrategyTest<out T : StringPermutationStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> {
            return listOf(
                "ab" to "eidbaooo" to true,
                "ab" to "eidboaoo" to false
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val expected = testCase.second
        val actual = strategy.perform(testCase.first.first, testCase.first.second)
        if (expected) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}

class PermutationBruteForceTest : PermutationInStringStrategyTest<PermutationBruteForce>(PermutationBruteForce())

class PermutationSortingTest : PermutationInStringStrategyTest<PermutationSorting>(PermutationSorting())

class PermutationHashmapTest : PermutationInStringStrategyTest<PermutationHashmap>(PermutationHashmap())

class PermutationArrayTest : PermutationInStringStrategyTest<PermutationArray>(PermutationArray())

class PermutationSlidingWindowTest :
    PermutationInStringStrategyTest<PermutationSlidingWindow>(PermutationSlidingWindow())

class PermutationOptimizedSlidingWindowTest :
    PermutationInStringStrategyTest<PermutationOptimizedSlidingWindow>(PermutationOptimizedSlidingWindow())
