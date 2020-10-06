package dev.shtanko.algorithms.learn

import org.junit.jupiter.api.Test

class DijkstraTest {

    private val edges = listOf(
        Edge("a", "b", 7),
        Edge("a", "c", 9),
        Edge("a", "f", 14),
        Edge("b", "c", 10),
        Edge("b", "d", 15),
        Edge("c", "d", 11),
        Edge("c", "f", 2),
        Edge("d", "e", 6),
        Edge("e", "f", 9)
    )

    @Test
    fun `should calculate correct shortest paths`() {
        with(Graph(edges = edges, true)) { // directed
            dijkstra("a")
            printPath("e")
        }
    }
}
