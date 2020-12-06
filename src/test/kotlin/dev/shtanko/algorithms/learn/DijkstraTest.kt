package dev.shtanko.algorithms.learn

import org.junit.jupiter.api.Test

class DijkstraTest {

    companion object {
        private const val START = "a"
        private const val END = "e"

        private val GRAPH = listOf(
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
    }

    @Test
    fun `should calculate correct shortest paths`() {
        with(Graph(edges = GRAPH, true)) { // directed
            dijkstra(START)
            printPath(END)
        }
    }
}
