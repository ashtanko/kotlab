package dev.shtanko.algorithms.leetcode

interface CountPrimesStrategy {
    fun perform(n: Int): Int
}

class CountPrimesBrutForce : CountPrimesStrategy {
    override fun perform(n: Int): Int {
        val notPrime = BooleanArray(n)
        var count = 0
        for (i in 2 until n) {
            if (!notPrime[i]) {
                count++
                var j = 2
                while (i * j < n) {
                    notPrime[i * j] = true
                    j++
                }
            }
        }
        return count
    }
}

class CountPrimesTimeComplexity : CountPrimesStrategy {
    override fun perform(n: Int): Int {
        if (n < 2) return 0
        val nonPrime = BooleanArray(n)
        nonPrime[1] = true
        var numNonPrimes = 1
        for (i in 2 until n) { // O(n)
            if (nonPrime[i]) continue
            var j = i * 2
            while (j < n) { // O(log(log(n)))
                if (!nonPrime[j]) {
                    nonPrime[j] = true
                    numNonPrimes++
                }
                j += i
            }
        }
        return n - 1 - numNonPrimes
    }
}
