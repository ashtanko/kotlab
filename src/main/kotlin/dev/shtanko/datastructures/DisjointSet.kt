package dev.shtanko.datastructures

/**
 * @link https://en.wikipedia.org/wiki/Disjoint-set_data_structure
 */
class DisjointSet(val size: Int) {
    private val parent = IntArray(size)
    private val rank = ByteArray(size)

    var count = size
        private set

    init {
        for (i in parent.indices) {
            parent[i] = i
        }
    }

    fun connected(v: Int, w: Int): Boolean {
        return find(v) == find(w)
    }

    private fun find(v: Int): Int {
        var value = v
        while (parent[value] != value) {
            parent[value] = parent[parent[value]]
            value = parent[value]
        }
        return value
    }

    fun union(v: Int, w: Int) {
        val rootV = find(v)
        val rootW = find(w)
        if (rootV == rootW) return
        when {
            rank[rootV] > rank[rootV] -> {
                parent[rootW] = rootV
            }
            rank[rootW] > rank[rootV] -> {
                parent[rootV] = rootW
            }
            else -> {
                parent[rootV] = rootW
                rank[rootW]++
            }
        }
        count--
    }
}
