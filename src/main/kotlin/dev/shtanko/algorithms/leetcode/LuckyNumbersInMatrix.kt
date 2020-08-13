package dev.shtanko.algorithms.leetcode

interface AbstractLuckyNumbersStrategy {
    fun perform(matrix: Array<IntArray>): List<Int>
}

class LuckyNumbers : AbstractLuckyNumbersStrategy {
    override fun perform(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size
        val mi = IntArray(m) { Integer.MAX_VALUE }
        val mx = IntArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                mi[i] = matrix[i][j].coerceAtMost(mi[i])
                mx[j] = matrix[i][j].coerceAtLeast(mx[j])
            }
        }
        val res: MutableList<Int> = ArrayList()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (mi[i] == mx[j]) {
                    res.add(mi[i])
                }
            }
        }

        return res
    }
}

class LuckyNumbersSet : AbstractLuckyNumbersStrategy {
    override fun perform(matrix: Array<IntArray>): List<Int> {
        val minSet: MutableSet<Int> = HashSet()
        val maxSet: MutableSet<Int> = HashSet()

        for (row in matrix) {
            var mi = row[0]
            for (cell in row) {
                mi = mi.coerceAtMost(cell)
            }
            minSet.add(mi)
        }

        for (j in matrix[0].indices) {
            var mx = matrix[0][j]
            for (i in matrix.indices) {
                mx = matrix[i][j].coerceAtLeast(mx)
            }
            if (minSet.contains(mx)) {
                maxSet.add(mx)
            }
        }

        return maxSet.toList()
    }
}
