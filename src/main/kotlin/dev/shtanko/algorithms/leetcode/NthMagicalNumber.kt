package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.math.gcd
import kotlin.math.ceil
import kotlin.math.min

private const val MOD = 1_000_000_007

interface NthMagicalNumberStrategy {
    fun perform(n: Int, a: Int, b: Int): Int
}

class NthMagicalNumberMath : NthMagicalNumberStrategy {

    override fun perform(n: Int, a: Int, b: Int): Int {
        val lcm = a * b / gcd(a, b)
        val cntPerLcm = lcm / a + lcm / b - 1
        val cntLcm = n / cntPerLcm
        val remain = n % cntPerLcm

        val nearest: Double = remain.div(1.0.div(a).plus(1.0.div(b)))
        val remainIdx = min(ceil(nearest / a) * a, ceil(nearest / b) * b).toInt()
        return cntLcm.times(lcm).plus(remainIdx) % MOD
    }
}

class NthMagicalNumberBS : NthMagicalNumberStrategy {
    override fun perform(n: Int, a: Int, b: Int): Int {
        val l: Int = a / gcd(a, b) * b

        var lo: Long = 0
        var hi: Long = n.toLong() * min(a, b)
        while (lo < hi) {
            val mi = lo + hi.minus(lo) / 2
            // If there are not enough magic numbers below mi...
            if (mi / a + mi / b - mi / l < n) lo = mi + 1 else hi = mi
        }

        return (lo % MOD).toInt()
    }
}