package dev.shtanko.algorithms.leetcode

/**
 * 1356. Sort Integers by The Number of 1 Bits
 */
fun interface SortByBits {
    operator fun invoke(arr: IntArray): IntArray
}

sealed interface SortByBitsStrategy {
    /**
     * Approach 1: Sort By Custom Comparator: Built-in
     */
    data object ComparatorSolution : SortByBits, SortByBitsStrategy {
        override fun invoke(arr: IntArray): IntArray {
            val comparator: Comparator<Int> = CustomComparator()
            return arr.sortedWith(comparator).toIntArray()
        }

        private class CustomComparator : Comparator<Int> {
            override fun compare(a: Int, b: Int): Int {
                return if (Integer.bitCount(a) == Integer.bitCount(b)) {
                    a - b
                } else Integer.bitCount(a) - Integer.bitCount(b)
            }
        }
    }

    /**
     * Approach 2: Bit Manipulation
     */
    data object BitManipulation : SortByBits, SortByBitsStrategy {
        override fun invoke(arr: IntArray): IntArray {
            val comparator: Comparator<Int> = CustomComparator()
            return arr.sortedWith(comparator).toIntArray()
        }

        private class CustomComparator : Comparator<Int> {
            private fun findWeight(num: Int): Int {
                var num0 = num
                var mask = 1
                var weight = 0
                while (num0 > 0) {
                    if (num0 and mask > 0) {
                        weight++
                        num0 = num0 xor mask
                    }
                    mask = mask shl 1
                }
                return weight
            }

            override fun compare(a: Int, b: Int): Int {
                return if (findWeight(a) == findWeight(b)) {
                    a - b
                } else findWeight(a) - findWeight(b)
            }
        }
    }

    /**
     * Approach 3: Brian Kerninghan's Algorithm
     */
    data object BrianKerninghansAlgorithm : SortByBits, SortByBitsStrategy {
        override fun invoke(arr: IntArray): IntArray {
            val comparator: Comparator<Int> = CustomComparator()
            return arr.sortedWith(comparator).toIntArray()
        }

        internal class CustomComparator : Comparator<Int> {
            private fun findWeight(num: Int): Int {
                var num0 = num
                var weight = 0
                while (num0 > 0) {
                    weight++
                    num0 = num0 and num0 - 1
                }
                return weight
            }

            override fun compare(a: Int, b: Int): Int {
                return if (findWeight(a) == findWeight(b)) {
                    a - b
                } else findWeight(a) - findWeight(b)
            }
        }
    }
}
