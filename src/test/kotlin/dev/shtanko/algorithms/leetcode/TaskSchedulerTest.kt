package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class TaskSchedulerTest<out T : TaskSchedulerStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<CharArray, Int>, Int>> {
            return listOf(
                charArrayOf('A', 'A', 'A', 'B', 'B', 'B') to 2 to 8,
                charArrayOf('A', 'A', 'A', 'B', 'B', 'B') to 0 to 6
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<Pair<CharArray, Int>, Int>) {
        val (data, expected) = testCase
        val (tasks, n) = data
        val actual = strategy.perform(tasks, n)
        assertEquals(expected, actual)
    }
}

internal class TaskSchedulerSimpleTest : TaskSchedulerTest<TaskSchedulerSimple>(TaskSchedulerSimple())

internal class TaskSchedulerPriorityQueueTest :
    TaskSchedulerTest<TaskSchedulerPriorityQueue>(TaskSchedulerPriorityQueue())
