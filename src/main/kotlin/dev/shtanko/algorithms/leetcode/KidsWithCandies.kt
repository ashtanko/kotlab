package dev.shtanko.algorithms.leetcode

interface KidsWithCandiesStrategy {
    fun perform(arr: IntArray, extraCandies: Int): BooleanArray
}

class KidsWithCandiesStraightForward : KidsWithCandiesStrategy {
    override fun perform(arr: IntArray, extraCandies: Int): BooleanArray {
        return arr.kidsWithCandies(extraCandies)
    }

    private fun IntArray.kidsWithCandies(extraCandies: Int): BooleanArray {
        val arr = BooleanArray(size) { true }

        for (i in indices) {
            if (this[i] + extraCandies < maxOrNull()!!) {
                arr[i] = false
            }
        }
        return arr
    }
}

class KidsWithCandiesStream : KidsWithCandiesStrategy {
    override fun perform(arr: IntArray, extraCandies: Int): BooleanArray {
        return arr.map {
            it + extraCandies >= arr.maxOrNull()!!
        }.toBooleanArray()
    }
}
