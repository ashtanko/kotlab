package dev.shtanko.algorithms.leetcode

import java.util.LinkedList

interface JumpGame5Strategy {
    fun perform(arr: IntArray): Int
}

class JP5BreadthFirstSearch : JumpGame5Strategy {
    override fun perform(arr: IntArray): Int {
        val n: Int = arr.size
        if (n <= 1) {
            return 0
        }

        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (i in 0 until n) {
            graph.computeIfAbsent(arr[i]) {
                LinkedList()
            }.add(i)
        }

        var curs: MutableList<Int> = LinkedList() // store current layer

        curs.add(0)
        val visited: MutableSet<Int> = HashSet()
        var step = 0

        // when current layer exists

        // when current layer exists
        while (curs.isNotEmpty()) {
            val nex: MutableList<Int> = LinkedList()

            // iterate the layer
            for (node in curs) {
                // check if reached end
                if (node == n - 1) {
                    return step
                }

                // check same value
                for (child in graph[arr[node]]!!) {
                    if (!visited.contains(child)) {
                        visited.add(child)
                        nex.add(child)
                    }
                }

                // clear the list to prevent redundant search
                graph[arr[node]]!!.clear()

                // check neighbors
                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1)
                    nex.add(node + 1)
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1)
                    nex.add(node - 1)
                }
            }
            curs = nex
            step++
        }

        return -1
    }
}

class JP5BidirectionalBFS : JumpGame5Strategy {
    override fun perform(arr: IntArray): Int {
        val n: Int = arr.size
        if (n <= 1) {
            return 0
        }

        val graph: MutableMap<Int, MutableList<Int>> = HashMap()
        for (i in 0 until n) {
            graph.computeIfAbsent(arr[i]) {
                LinkedList()
            }.add(i)
        }

        var curs: MutableList<Int> = LinkedList() // store layers from start

        curs.add(0)
        val visited: MutableSet<Int> = HashSet()
        visited.add(0)
        visited.add(n - 1)
        var step = 0

        var other: MutableList<Int> = LinkedList() // store layers from end

        other.add(n - 1)

        // when current layer exists

        // when current layer exists
        while (curs.isNotEmpty()) {
            // search from the side with fewer nodes
            if (curs.size > other.size) {
                val tmp = curs
                curs = other
                other = tmp
            }
            val nex: MutableList<Int> = LinkedList()

            // iterate the layer
            for (node in curs) {

                // check same value
                for (child in graph[arr[node]]!!) {
                    if (other.contains(child)) {
                        return step + 1
                    }
                    if (!visited.contains(child)) {
                        visited.add(child)
                        nex.add(child)
                    }
                }

                // clear the list to prevent redundant search
                graph[arr[node]]?.clear()

                // check neighbors
                if (other.contains(node + 1) || other.contains(node - 1)) {
                    return step + 1
                }
                if (node + 1 < n && !visited.contains(node + 1)) {
                    visited.add(node + 1)
                    nex.add(node + 1)
                }
                if (node - 1 >= 0 && !visited.contains(node - 1)) {
                    visited.add(node - 1)
                    nex.add(node - 1)
                }
            }
            curs = nex
            step++
        }

        return -1
    }
}

class JP5BidirectionalBFS2 : JumpGame5Strategy {
    override fun perform(arr: IntArray): Int {
        val totalNums = arr.size
        if (totalNums == 1) return 0

        // a map of value to indexes of `nums`
        val idxMap = HashMap<Int, ArrayList<Int>>()
        for (idx in totalNums - 1 downTo 0) {
            idxMap.getOrPut(arr[idx]) { arrayListOf() }.add(idx)
        }

        val visited = BooleanArray(totalNums) { false }

        var head = HashSet<Int>()
        head.add(0)
        visited[0] = true

        var tail = HashSet<Int>()
        tail.add(totalNums - 1)
        visited[totalNums - 1] = true

        var steps = 0

        while (head.isNotEmpty() && tail.isNotEmpty()) {
            if (head.size > tail.size) {
                // to swap the two sets
                head = tail.also { tail = head }
            }

            val next = HashSet<Int>()
            for (idx in head) {
                val hiNext = idx + 1
                if (tail.contains(hiNext)) return steps + 1
                if (hiNext in 0 until totalNums && !visited[hiNext]) {
                    next.add(hiNext)
                }

                val loNext = idx - 1
                if (tail.contains(loNext)) return steps + 1
                if (loNext in 0 until totalNums && !visited[loNext]) {
                    next.add(loNext)
                }

                idxMap[arr[idx]]?.let {
                    for (equalValueNext in it) {
                        if (tail.contains(equalValueNext)) return steps + 1

                        if (visited[equalValueNext]) continue
                        next.add(equalValueNext)
                        visited[equalValueNext] = true
                    }

                    // to save time
                    // there is no need to check visited/seen at all later on
                    it.clear()
                }
            }

            head = next
            ++steps
        }

        return -1
    }
}
