package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class UniqueCharactersTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, Boolean>> {
            return listOf(
                "abc" to true,
                "ccc" to false
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `unique characters test`(testCase: Pair<String, Boolean>) {
        val actual = uniqueCharacters(testCase.first)
        if (testCase.second) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
