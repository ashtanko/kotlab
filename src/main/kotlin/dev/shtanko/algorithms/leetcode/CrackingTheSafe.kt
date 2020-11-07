package dev.shtanko.algorithms.leetcode

import kotlin.math.pow

interface CrackingSafeStrategy {
    fun perform(n: Int, k: Int): String
}

class CrackingSafeHierholzersAlgorithm : CrackingSafeStrategy {

    private val seen: MutableSet<String> = HashSet()
    private val ans: StringBuilder = StringBuilder()

    override fun perform(n: Int, k: Int): String {
        if (n == 1 && k == 1) return "0"
        val sb = StringBuilder()
        for (i in 0 until n - 1) sb.append("0")
        val start = sb.toString()

        dfs(start, k)
        ans.append(start)
        return ans.toString()
    }

    private fun dfs(node: String, k: Int) {
        for (x in 0 until k) {
            val nei = node + x
            if (!seen.contains(nei)) {
                seen.add(nei)
                dfs(nei.substring(1), k)
                ans.append(x)
            }
        }
    }
}

class CrackingSafeInverseBurrowsWheelerTransform : CrackingSafeStrategy {
    override fun perform(n: Int, k: Int): String {
        val m = k.toDouble().pow((n - 1).toDouble()).toInt()
        val p = IntArray(m * k)
        for (i in 0 until k) for (q in 0 until m) p[i * m + q] = q * k + i

        val ans = StringBuilder()
        for (i in 0 until m * k) {
            var j = i
            while (p[j] >= 0) {
                ans.append((j / m).toString())
                val v = p[j]
                p[j] = -1
                j = v
            }
        }

        for (i in 0 until n - 1) ans.append("0")
        return ans.toString()
    }
}
