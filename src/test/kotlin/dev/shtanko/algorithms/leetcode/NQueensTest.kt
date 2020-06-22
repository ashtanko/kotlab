package dev.shtanko.algorithms.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NQueensTest {

    @Test
    fun `simple test`() {
        val target = 4
        val actual = target.solveNQueens()
        val expected = listOf(
            listOf(".Q..", "...Q", "Q...", "..Q."),
            listOf("..Q.", "Q...", "...Q", ".Q..")
        )
        assertThat(expected).isEqualTo(actual)
    }
}
