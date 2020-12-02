package dev.shtanko.game

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `display empty grid test`() {
        val grid = arrayOf(
            intArrayOf()
        )
        display(grid)
    }

    @Test
    fun `organize test`() {
        val row = intArrayOf()
        val idxToMatch = 0
        val idxToCompare = 1
        val actual = organize(row, idxToMatch, idxToCompare)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `merge test`() {
        val row = intArrayOf()
        val idxToMatch = 0
        val idxToCompare = 1
        val actual = merge(row, idxToMatch, idxToCompare)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `merge and organize cells test`() {
        val row = intArrayOf()
        val actual = mergeAndOrganizeCells(row)
        val expected = intArrayOf()
        assertArrayEquals(expected, actual)
    }

    @Test
    fun `shift cells down test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            shiftCellsDown(grid)
        }
    }

    @Test
    fun `shift cells up test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            shiftCellsUp(grid)
        }
    }

    @Test
    fun `shift cells right test`() {
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
    fun `shift cells left test`() {
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
    fun `manipulate grid with unsupported input test`() {
        assertThrows(IllegalArgumentException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            val input = ""
            manipulateGrid(grid, input)
        }
    }

    @Test
    fun `manipulate grid with A input test`() {
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
    fun `manipulate grid with S input test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            val input = "s"
            manipulateGrid(grid, input)
        }
    }

    @Test
    fun `manipulate grid with D input test`() {
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
    fun `manipulate grid with W input test`() {
        assertThrows(ArrayIndexOutOfBoundsException::class.java) {
            val grid = arrayOf(
                intArrayOf()
            )
            val input = "w"
            manipulateGrid(grid, input)
        }
    }

    @Test
    fun `when invalid input test`() {
        assertFalse(isValidInput(""))
    }

    @Test
    fun `when valid input test`() {
        assertTrue(isValidInput("a"))
        assertTrue(isValidInput("s"))
        assertTrue(isValidInput("d"))
        assertTrue(isValidInput("w"))
    }
}
