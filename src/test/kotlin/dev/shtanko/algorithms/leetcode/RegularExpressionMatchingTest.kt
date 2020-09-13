package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

abstract class RegularExpressionMatchingStrategyTest<out T : RegularExpressionMatchStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        assertFalse(strategy.perform("aa", "a"))
    }

    @Test
    fun `simple test 2`() {
        assertTrue(strategy.perform("aa", "a*"))
    }

    @Test
    fun `simple test 3`() {
        assertTrue(strategy.perform("ab", ".*"))
    }

    @Test
    fun `simple test 4`() {
        assertTrue(strategy.perform("aab", "c*a*b"))
    }

    @Test
    fun `simple test 5`() {
        assertFalse(strategy.perform("mississippi", "mis*is*p*."))
    }
}

class RegularExpressionMatchRecursionTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchRecursion>(RegularExpressionMatchRecursion())

class RegularExpressionMatchDPTopDownTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPTopDown>(RegularExpressionMatchDPTopDown())

class RegularExpressionMatchDPBottomUpTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPBottomUp>(RegularExpressionMatchDPBottomUp())
