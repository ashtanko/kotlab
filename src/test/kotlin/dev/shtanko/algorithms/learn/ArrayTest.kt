/*
 * Copyright 2020 Alexey Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.learn

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ArrayTest {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                2 to intArrayOf(1, 3, 2, 4, 5),
                10 to intArrayOf(12, 25, 8, 55, 10, 33, 17, 11),
                8 to intArrayOf(4, 8, 15, 16, 23, 42)
            )
        }

        @JvmStatic
        fun firstUniqueProvider(): List<Any> {
            return listOf(
                intArrayOf(1, 2, 3, 4, 5) to intArrayOf(
                    1, 1, 2, 2, 2, 3, 3, 4, 5, 5
                )
            )
        }

        @JvmStatic
        fun mergeArrayDataProvider(): List<Pair<Pair<IntArray, IntArray>, IntArray>> {
            return listOf(
                intArrayOf(1, 2, 3, 4, 5, 6) to intArrayOf(7, 8, 9) to intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `find min using sort test`(testCase: Pair<Int, IntArray>) {
        val arr = testCase.second
        val expected = testCase.first
        val actual = secondMinSort(arr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `find min second straight forward test`(testCase: Pair<Int, IntArray>) {
        val arr = testCase.second
        val expected = testCase.first
        val actual = secondStraightForward(arr)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("firstUniqueProvider")
    fun `find first unique elements test`(testCase: Pair<IntArray, IntArray>) {
        val arr = testCase.second
        val expected = testCase.first
        val actual = uniqueWholeNumbersSet(arr)
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("mergeArrayDataProvider")
    fun `merge two sorted arrays using plus operator test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val arr1 = testCase.first.first
        val arr2 = testCase.first.second
        val expected = testCase.second
        val actual = mergeTwoSortedPlus(arr1, arr2)
        assertArrayEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("mergeArrayDataProvider")
    fun `merge two sorted arrays straight forward test`(testCase: Pair<Pair<IntArray, IntArray>, IntArray>) {
        val arr1 = testCase.first.first
        val arr2 = testCase.first.second
        val expected = testCase.second
        val actual = mergeTwoSortedSF(arr1, arr2)
        assertArrayEquals(expected, actual)
    }
}
