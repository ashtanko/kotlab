package dev.shtanko.algorithms.leetcode

interface CountTheRepetitionsStrategy {
    fun perform(s1: String, n1: Int, s2: String, n2: Int): Int
}

class CountTheRepetitionsBruteForce : CountTheRepetitionsStrategy {
    override fun perform(s1: String, n1: Int, s2: String, n2: Int): Int {
        var index = 0
        var repeatCount = 0
        val s1Size: Int = s1.length
        val s2Size: Int = s2.length
        for (i in 0 until n1) {
            for (j in 0 until s1Size) {
                if (s1[j] == s2[index]) ++index
                if (index == s2Size) {
                    index = 0
                    ++repeatCount
                }
            }
        }
        return repeatCount / n2
    }
}

class CountTheRepetitionsBetterBruteForce : CountTheRepetitionsStrategy {

    companion object {
        private const val ARRAY_SIZE = 102
    }

    override fun perform(s1: String, n1: Int, s2: String, n2: Int): Int {
        val reps = IntArray(ARRAY_SIZE)
        val rests = IntArray(ARRAY_SIZE)
        var posRest = 0
        var repTime = 0
        var i = 0
        var k = 0
        if (n1 <= 0) return 0
        while (k == i) {
            i++
            for (j in s1.indices) {
                if (s2[posRest] == s1[j]) {
                    posRest++
                    if (posRest == s2.length) {
                        repTime++
                        posRest = 0
                    }
                }
            }
            if (i >= n1) return repTime / n2
            k = 0
            while (k < i) {
                if (posRest == rests[k]) break
                k++
            }
            reps[i] = repTime
            rests[i] = posRest
        }
        val interval = i - k
        val repeatCount = n1.plus(k) / interval
        val repeatTimes = repeatCount * reps[i].minus(reps[k])
        val remainTimes = reps[n1.minus(k) % interval + k]
        return repeatTimes.plus(remainTimes) / n2
    }
}
