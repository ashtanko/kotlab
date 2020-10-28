package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class TaskSchedulerTest<out T : TaskSchedulerStrategy>(private val strategy: T) {

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
    fun `simple test`(testCase: Pair<Pair<CharArray, Int>, Int>) {
        val tasks = testCase.first.first
        val n = testCase.first.second
        val expected = testCase.second
        val actual = strategy.perform(tasks, n)
        assertEquals(expected, actual)
    }
}

class TaskSchedulerSimpleTest : TaskSchedulerTest<TaskSchedulerSimple>(TaskSchedulerSimple())

class TaskSchedulerPriorityQueueTest : TaskSchedulerTest<TaskSchedulerPriorityQueue>(TaskSchedulerPriorityQueue())
