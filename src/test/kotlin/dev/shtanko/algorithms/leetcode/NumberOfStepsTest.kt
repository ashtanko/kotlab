package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStepsTest {

    @Test
    fun `simple test`() {
        assertEquals(6, 14.numberOfSteps())
    }

    @Test
    fun `simple test 2`() {
        assertEquals(4, 8.numberOfSteps())
    }

    @Test
    fun `simple test 3`() {
        assertEquals(12, 123.numberOfSteps())
    }

    @Test
    fun `simple test 4`() {
        assertEquals(6, 14.numberOfStepsBinary())
    }

    @Test
    fun `simple test 5`() {
        assertEquals(4, 8.numberOfStepsBinary())
    }

    @Test
    fun `simple test 6`() {
        assertEquals(12, 123.numberOfStepsBinary())
    }
}
