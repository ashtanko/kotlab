package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class ContainerWithMostWaterStrategyTest<out T : ContainerWithMostWaterStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49),
                Arguments.of(intArrayOf(4, 8, 15, 16, 23, 42), 45),
                Arguments.of(intArrayOf(), 0),
                Arguments.of(intArrayOf(1), 0),
                Arguments.of(intArrayOf(1, 1), 1),
                Arguments.of(intArrayOf(1, 1, 3), 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun `simple test`(arr: IntArray, expected: Int) {
        val actual = strategy.maxArea(arr)
        assertEquals(expected, actual)
    }
}

class ContainerWithMostWaterBruteForceTest :
    ContainerWithMostWaterStrategyTest<ContainerWithMostWaterBruteForce>(ContainerWithMostWaterBruteForce())

class ContainerWithMostWaterTwoPointerTest :
    ContainerWithMostWaterStrategyTest<ContainerWithMostWaterTwoPointer>(ContainerWithMostWaterTwoPointer())
