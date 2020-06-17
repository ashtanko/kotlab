package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContainsDuplicateTest {

    private val duplicateShortArray = intArrayOf(1, 2, 3, 1)
    private val duplicateArray = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
    private val uniqueArray = intArrayOf(1, 2, 3, 4)

    @Test
    fun `duplicate items brut force test`() {
        assertTrue(duplicateShortArray.isContainsDuplicateBrutForce())
    }

    @Test
    fun `unique items brut force test`() {
        assertFalse(uniqueArray.isContainsDuplicateBrutForce())
    }

    @Test
    fun `a lot of same items brut force test`() {
        assertTrue(duplicateArray.isContainsDuplicateBrutForce())
    }

    @Test
    fun `duplicate items using sort test`() {
        assertTrue(duplicateShortArray.isContainsDuplicateSort())
    }

    @Test
    fun `unique items using sort test`() {
        assertFalse(uniqueArray.isContainsDuplicateSort())
    }

    @Test
    fun `a lot of same using sort test`() {
        assertTrue(duplicateArray.isContainsDuplicateSort())
    }

    @Test
    fun `duplicate items using set size test`() {
        assertTrue(duplicateShortArray.isContainsDuplicateSimpleSet())
    }

    @Test
    fun `unique items using set size test`() {
        assertFalse(uniqueArray.isContainsDuplicateSimpleSet())
    }

    @Test
    fun `a lot of same using set size test`() {
        assertTrue(duplicateArray.isContainsDuplicateSimpleSet())
    }

    @Test
    fun `duplicate items using set test`() {
        assertTrue(duplicateShortArray.isContainsDuplicateSet())
    }

    @Test
    fun `unique items using set test`() {
        assertFalse(uniqueArray.isContainsDuplicateSet())
    }

    @Test
    fun `a lot of same using set test`() {
        assertTrue(duplicateArray.isContainsDuplicateSet())
    }

    @Test
    fun `duplicate items using set2 test`() {
        assertTrue(duplicateShortArray.isContainsDuplicateSet2())
    }

    @Test
    fun `unique items using set2 test`() {
        assertFalse(uniqueArray.isContainsDuplicateSet2())
    }

    @Test
    fun `a lot of same using set2 test`() {
        assertTrue(duplicateArray.isContainsDuplicateSet2())
    }

    @Test
    fun `duplicate items bit manipulation test`() {
        assertTrue(duplicateShortArray.isContainsDuplicateBitManipulation())
    }

    @Test
    fun `unique items bit manipulation test`() {
        assertFalse(uniqueArray.isContainsDuplicateBitManipulation())
    }

    @Test
    fun `a lot of same bit manipulation test`() {
        assertTrue(duplicateArray.isContainsDuplicateBitManipulation())
    }
}
