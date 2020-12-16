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

package dev.shtanko.game

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameTest {

    @Test
    internal fun `display empty grid test`() {
        val grid = arrayOf(
            intArrayOf()
        )
        display(grid)
    }

    @Test
    internal fun `organize test`() {
        val row = intArrayOf()
        val idxToMatch = 0
        val idxToCompare = 1
        val actual = organize(row, idxToMatch, idxToCompare)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    internal fun `merge test`() {
        val row = intArrayOf()
        val idxToMatch = 0
        val idxToCompare = 1
        val actual = merge(row, idxToMatch, idxToCompare)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    internal fun `merge and organize cells test`() {
        val row = intArrayOf()
        val actual = mergeAndOrganizeCells(row)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    internal fun `shift cells down test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            shiftCellsDown(grid)
        }
    }

    @Test
    internal fun `shift cells up test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            shiftCellsUp(grid)
        }
    }

    @Test
    internal fun `shift cells right test`() {
        val grid = arrayOf(
            intArrayOf()
        )
        val actual = shiftCellsRight(grid)
        val expected = arrayOf(
            intArrayOf()
        )
        assertArrayEquals(expected, actual)
    }

    @Test
    internal fun `shift cells left test`() {
        val grid = arrayOf(
            intArrayOf()
        )
        val actual = shiftCellsLeft(grid)
        val expected = arrayOf(
            intArrayOf()
        )
        assertArrayEquals(expected, actual)
    }

    @Test
    internal fun `manipulate grid with unsupported input test`() {
        assertThrows(IllegalArgumentException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            val input = ""
            manipulateGrid(grid, input)
        }
    }

    @Test
    internal fun `manipulate grid with A input test`() {
        val grid = arrayOf(
            intArrayOf()
        )
        val input = "a"
        val actual = manipulateGrid(grid, input)
        val expected = arrayOf(
            intArrayOf()
        )
        assertArrayEquals(expected, actual)
    }

    @Test
    internal fun `manipulate grid with S input test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            val input = "s"
            manipulateGrid(grid, input)
        }
    }

    @Test
    internal fun `manipulate grid with D input test`() {
        val grid = arrayOf(
            intArrayOf()
        )
        val input = "d"
        val actual = manipulateGrid(grid, input)
        val expected = arrayOf(
            intArrayOf()
        )
        assertArrayEquals(expected, actual)
    }

    @Test
    internal fun `manipulate grid with W input test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            val input = "w"
            manipulateGrid(grid, input)
        }
    }

    @Test
    internal fun `when invalid input test`() {
        assertFalse(isValidInput(""))
    }

    @Test
    internal fun `when valid input test`() {
        assertTrue(isValidInput("a"))
        assertTrue(isValidInput("s"))
        assertTrue(isValidInput("d"))
        assertTrue(isValidInput("w"))
    }
}
