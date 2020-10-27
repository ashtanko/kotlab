package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class DestinationCityTest<out T : DestinationCityStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<List<List<String>>, String>> {
            return listOf(
                listOf(
                    listOf("London", "New York"),
                    listOf("New York", "Lima"),
                    listOf("Lima", "Sao Paulo"),
                ) to "Sao Paulo",
                listOf(
                    listOf("B", "C"),
                    listOf("D", "B"),
                    listOf("C", "A"),
                ) to "A"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `destination city test`(testCase: Pair<List<List<String>>, String>) {
        val actual = strategy.perform(testCase.first)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

class DestinationCitySetTest : DestinationCityTest<DestinationCitySet>(DestinationCitySet())

class DestinationCityHashMapTest : DestinationCityTest<DestinationCityHashMap>(DestinationCityHashMap())
