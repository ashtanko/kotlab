package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.dp.fibonacciAt
import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.math.sqrt

interface FibonacciStrategy {
    fun perform(n: Int): Long
}

class FibonacciRecursion : FibonacciStrategy {
    override fun perform(n: Int): Long {
        if (n <= 1) {
            return n.toLong()
        }
        return perform(n - 1) + perform(n - 2)
    }
}

class FibonacciOptimizedRecursion : FibonacciStrategy {
    override fun perform(n: Int): Long {
        return fibonacciAt(n)
    }
}

class FibonacciBottomUp : FibonacciStrategy {
    override fun perform(n: Int): Long {
        if (n <= 1) {
            return n.toLong()
        }
        return memoize(n)
    }

    private fun memoize(n: Int): Long {
        val cache = LongArray(n + 1)
        cache[1] = 1
        for (i in 2..n) {
            cache[i] = cache[i - 1] + cache[i - 2]
        }
        return cache[n]
    }
}

class FibonacciTopDown : FibonacciStrategy {

    private val cache = arrayOfNulls<Long>(60)

    override fun perform(n: Int): Long {
        if (n <= 1) {
            return n.toLong()
        }
        cache[0] = 0
        cache[1] = 1
        return memoize(n)
    }

    private fun memoize(n: Int): Long {
        if (cache[n] != null) {
            return cache[n]!!
        }
        cache[n] = memoize(n - 1) + memoize(n - 2)
        return memoize(n)
    }
}

class FibonacciIterativeTopDown : FibonacciStrategy {
    override fun perform(n: Int): Long {
        if (n <= 1) {
            return n.toLong()
        }
        if (n == 2) {
            return 1
        }

        var current = 0
        var prev1 = 1
        var prev2 = 1

        for (i in 3..n) {
            current = prev1 + prev2
            prev2 = prev1
            prev1 = current
        }
        return current.toLong()
    }
}

class FibonacciMatrixExponentiation : FibonacciStrategy {
    override fun perform(n: Int): Long {
        if (n <= 1) {
            return n.toLong()
        }
        val a = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
        matrixPower(a, n - 1)

        return a[0][0].toLong()
    }

    private fun matrixPower(arr: Array<IntArray>, n: Int) {
        if (n <= 1) {
            return
        }
        matrixPower(arr, n / 2)
        multiply(arr, arr)
        val b = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
        if (n % 2 != 0) {
            multiply(arr, b)
        }
    }

    private fun multiply(matrixA: Array<IntArray>, matrixB: Array<IntArray>) {
        val x = matrixA[0][0] * matrixB[0][0] + matrixA[0][1] * matrixB[1][0]
        val y = matrixA[0][0] * matrixB[0][1] + matrixA[0][1] * matrixB[1][1]
        val z = matrixA[1][0] * matrixB[0][0] + matrixA[1][1] * matrixB[1][0]
        val w = matrixA[1][0] * matrixB[0][1] + matrixA[1][1] * matrixB[1][1]
        matrixA[0][0] = x
        matrixA[0][1] = y
        matrixA[1][0] = z
        matrixA[1][1] = w
    }
}

class FibonacciMath : FibonacciStrategy {

    companion object {
        private const val GOLDEN_RATIO_VALUE = 5.0
    }

    override fun perform(n: Int): Long {
        val goldenRatio = 1.plus(sqrt(GOLDEN_RATIO_VALUE)) / 2
        return goldenRatio.pow(n).div(sqrt(GOLDEN_RATIO_VALUE)).roundToLong()
    }
}