package dev.shtanko.datastructures.tree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.util.PriorityQueue
import java.util.Random
import java.util.stream.IntStream

class HeapTest {

    companion object {
        val RANDOM = Random()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 10, 100, 1000, 10000, 100000])
    fun `heap test`(size: Int) {
        val priorityQueue = PriorityQueue<Int>()
        val heap = Heap<Int>(naturalOrder())

        IntStream.generate { RANDOM.nextInt() }
            .limit(size.toLong())
            .forEach { priorityQueue.add(it); heap.add(it) }

        assertEquals(size, heap.size())
        for (i in 1..size) {
            assertEquals(priorityQueue.peek(), heap.peek())
            assertEquals(priorityQueue.poll(), heap.poll())
        }
    }
}
