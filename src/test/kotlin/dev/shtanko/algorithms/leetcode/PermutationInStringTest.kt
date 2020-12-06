package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class PermutationInStringStrategyTest<out T : StringPermutationStrategy>(private val strategy: T) {

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
    internal fun `simple test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val (data, expected) = testCase
        val (s1, s2) = data
        val actual = strategy.perform(s1, s2)
        assertEquals(expected, actual)
    }
}

internal class PermutationBruteForceTest :
    PermutationInStringStrategyTest<PermutationBruteForce>(PermutationBruteForce())

internal class PermutationSortingTest : PermutationInStringStrategyTest<PermutationSorting>(PermutationSorting())

internal class PermutationHashmapTest : PermutationInStringStrategyTest<PermutationHashmap>(PermutationHashmap())

internal class PermutationArrayTest : PermutationInStringStrategyTest<PermutationArray>(PermutationArray())

internal class PermutationSlidingWindowTest :
    PermutationInStringStrategyTest<PermutationSlidingWindow>(PermutationSlidingWindow())

internal class PermutationOptimizedSlidingWindowTest :
    PermutationInStringStrategyTest<PermutationOptimizedSlidingWindow>(PermutationOptimizedSlidingWindow())
