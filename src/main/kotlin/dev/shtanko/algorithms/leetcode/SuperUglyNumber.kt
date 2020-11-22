package dev.shtanko.algorithms.leetcode

import java.util.Arrays
import java.util.PriorityQueue
import kotlin.math.min

interface SuperUglyNumberStrategy {
    fun perform(n: Int, primes: IntArray): Int
}

class SuperUglyNumberCommon : SuperUglyNumberStrategy {
    override fun perform(n: Int, primes: IntArray): Int {
        val ugly = IntArray(n)
        val idx = IntArray(primes.size)

        ugly[0] = 1
        for (i in 1 until n) {
            // find next
            ugly[i] = Int.MAX_VALUE
            for (j in primes.indices) ugly[i] = min(ugly[i], primes[j] * ugly[idx[j]])

            // slip duplicate
            for (j in primes.indices) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++
            }
        }

        return ugly[n - 1]
    }
}

class SuperUglyNumberRedundantMultiplication : SuperUglyNumberStrategy {
    override fun perform(n: Int, primes: IntArray): Int {
        val ugly = IntArray(n)
        val idx = IntArray(primes.size)
        val values = IntArray(primes.size)
        Arrays.fill(values, 1)

        var next = 1
        for (i in 0 until n) {
            ugly[i] = next
            next = Int.MAX_VALUE
            for (j in primes.indices) {
                // skip duplicate and avoid extra multiplication
                if (values[j] == ugly[i]) values[j] = ugly[idx[j]++] * primes[j]
                // find next ugly number
                next = min(next, values[j])
            }
        }

        return ugly[n - 1]
    }
}

class SuperUglyNumberHeap : SuperUglyNumberStrategy {
    override fun perform(n: Int, primes: IntArray): Int {
        val ugly = IntArray(n)

        val pq: PriorityQueue<Num> = PriorityQueue()
        for (i in primes.indices) pq.add(Num(primes[i], 1, primes[i]))
        ugly[0] = 1

        for (i in 1 until n) {
            ugly[i] = pq.peek().value
            while (pq.peek().value == ugly[i]) {
                val nxt: Num = pq.poll()
                pq.add(Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p))
            }
        }

        return ugly[n - 1]
    }

    class Num(var value: Int, var idx: Int, var p: Int) : Comparable<Num?> {
        override fun compareTo(other: Num?): Int {
            return value - other?.value!!
        }
    }
}
