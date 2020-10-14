package dev.shtanko.algorithms.leetcode

internal class DesignHashMap {
    private val nodes = Array<ListNode?>(10_000) { null }

    fun put(key: Int, value: Int) {
        val i = idx(key)
        if (nodes[i] == null) {
            nodes[i] = ListNode(-1, -1)
        }
        val prev = find(nodes[i], key)
        if (prev?.next == null) {
            prev?.next = ListNode(key, value)
        } else {
            prev.next?.value = value
        }
    }

    fun get(key: Int): Int {
        val i = idx(key)
        if (nodes[i] == null) return -1
        val node = find(nodes[i], key)
        return if (node?.next == null) -1 else node.next?.value ?: -1
    }

    fun remove(key: Int) {
        val i = idx(key)
        if (nodes[i] == null) return
        val prev = find(nodes[i], key)
        if (prev?.next == null) return
        prev.next = prev.next?.next
    }

    private fun idx(key: Int): Int = Integer.hashCode(key) % nodes.size

    private fun find(bucket: ListNode?, key: Int): ListNode? {
        var node: ListNode? = bucket
        var prev: ListNode? = null
        while (node != null && node.key != key) {
            prev = node
            node = node.next
        }
        return prev
    }

    internal class ListNode(val key: Int, var value: Int) {
        var next: ListNode? = null
    }
}
