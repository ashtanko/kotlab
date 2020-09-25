package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Stack

interface MergeIntervalsStrategy {
    fun perform(intervals: Array<IntArray>): Array<IntArray>
}

class MergeIntervalsConnectedComponents : MergeIntervalsStrategy {

    private var graph: MutableMap<IntArray, MutableList<IntArray>> = HashMap()
    private var nodesInComp: MutableMap<Int, MutableList<IntArray>> = HashMap()
    private var visited: MutableSet<IntArray> = HashSet()

    override fun perform(intervals: Array<IntArray>): Array<IntArray> {
        return merge(intervals)
    }

    // return whether two intervals overlap (inclusive)
    private fun overlap(a: IntArray, b: IntArray): Boolean {
        return a[0] <= b[1] && b[0] <= a[1]
    }

    // build a graph where an undirected edge between intervals u and v exists
    // iff u and v overlap.
    private fun buildGraph(intervals: Array<IntArray>) {
        for (interval in intervals) {
            graph[interval] = LinkedList<IntArray>()
        }
        for (interval1 in intervals) {
            for (interval2 in intervals) {
                if (overlap(interval1, interval2)) {
                    graph[interval1]?.add(interval2)
                    graph[interval2]?.add(interval1)
                }
            }
        }
    }

    // merges all of the nodes in this connected component into one interval.
    private fun mergeNodes(nodes: List<IntArray>): IntArray {
        var minStart = nodes[0][0]
        for (node in nodes) {
            minStart = minStart.coerceAtMost(node[0])
        }
        var maxEnd = nodes[0][1]
        for (node in nodes) {
            maxEnd = maxEnd.coerceAtLeast(node[1])
        }
        return intArrayOf(minStart, maxEnd)
    }

    // use depth-first search to mark all nodes in the same connected component
    // with the same integer.
    private fun markComponentDFS(start: IntArray, compNumber: Int) {
        val stack: Stack<IntArray> = Stack()
        stack.add(start)
        while (!stack.isEmpty()) {
            val node: IntArray = stack.pop()
            if (!visited.contains(node)) {
                visited.add(node)
                if (nodesInComp[compNumber] == null) {
                    nodesInComp[compNumber] = LinkedList()
                }
                nodesInComp[compNumber]?.add(node)
                graph[node]?.let {
                    for (child in it) {
                        stack.add(child)
                    }
                }
            }
        }
    }

    // gets the connected components of the interval overlap graph.
    private fun buildComponents(intervals: Array<IntArray>) {
        var compNumber = 0
        for (interval in intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber)
                compNumber++
            }
        }
    }

    private fun merge(intervals: Array<IntArray>): Array<IntArray> {
        buildGraph(intervals)
        buildComponents(intervals)

        // for each component, merge all intervals into one interval.
        val merged: MutableList<IntArray> = LinkedList()
        for (element in nodesInComp) {
            merged.add(mergeNodes(element.value))
        }
        return merged.toTypedArray()
    }
}

class MergeIntervalsSorting : MergeIntervalsStrategy {

    override fun perform(intervals: Array<IntArray>): Array<IntArray> {
        val i = intervals.toList().sortedWith(IntervalComparator())
        val merged = LinkedList<IntArray>()
        for (interval in i) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.last[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last[1] = merged.last[1].coerceAtLeast(interval[1])
            }
        }

        return merged.toTypedArray()
    }

    private class IntervalComparator : Comparator<IntArray?> {
        override fun compare(a: IntArray?, b: IntArray?): Int {
            if (a == null || b == null) return -1
            return if (a[0] < b[0]) -1 else if (a[0] == b[0]) 0 else 1
        }
    }
}
