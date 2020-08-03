package dev.shtanko.algorithms.learn

import org.junit.jupiter.api.Test

class DijkstraTest {

    @Test
    fun `should calculate correct shortest paths`() {
        val weights = mapOf(
            Pair("A", "B") to 2,
            Pair("A", "C") to 8,
            Pair("A", "D") to 5,
            Pair("B", "C") to 1,
            Pair("C", "E") to 3,
            Pair("D", "E") to 2
        )

        val start = "A"
        // val shortestPathTree = dijkstra(Graph(weights), start)

        // assertEquals(listOf(start, "B", "C"), shortestPath(shortestPathTree, start, "C"))
        // assertEquals(listOf(start, "B", "C", "E"), shortestPath(shortestPathTree, start, "E"))
        // assertEquals(listOf(start, "D"), shortestPath(shortestPathTree, start, "D"))
    }
}
