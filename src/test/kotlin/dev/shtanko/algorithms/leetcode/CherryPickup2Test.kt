package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class CherryPickup2Test<out T : CherryPickup2Strategy>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(3, 1, 1),
                    intArrayOf(2, 5, 1),
                    intArrayOf(1, 5, 5),
                    intArrayOf(2, 1, 1)
                ),
                24
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `cherry pickup test`(grid: Array<IntArray>, expected: Int) {
        val actual = strategy.perform(grid)
        assertEquals(expected, actual)
    }
}

class CherryPickup2DPTopDownTest : CherryPickup2Test<CherryPickup2DPTopDown>(CherryPickup2DPTopDown())

class CherryPickup2DPBottomUpTest : CherryPickup2Test<CherryPickup2DPBottomUp>(CherryPickup2DPBottomUp())
