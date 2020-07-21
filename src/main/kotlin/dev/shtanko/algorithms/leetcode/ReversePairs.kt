package dev.shtanko.algorithms.leetcode

private data class Node(val value: Int, var cnt: Int = 1, var left: Node? = null, var right: Node? = null)

private fun Node?.search(value: Int): Int {
    return when {
        this == null -> {
            0
        }
        value == this.value -> {
            this.cnt
        }
        value < this.value -> {
            this.cnt + this.left.search(value)
        }
        else -> {
            this.right.search(value)
        }
    }
}

private fun insert(r: Node?, value: Int): Node? {
    var root = r
    when {
        root == null -> {
            root = Node(value)
        }
        value == root.value -> {
            root.cnt++
        }
        value < root.value -> {
            root.left = insert(root.left, value)
        }
        else -> {
            root.cnt++
            root.right = insert(root.right, value)
        }
    }

    return root
}

fun IntArray.reversePairsBST(): Int {
    var res = 0
    var root: Node? = null
    for (ele in this) {
        res += root.search(2 * ele + 1)
        root = insert(root, ele)
    }
    return res
}

fun IntArray.reversePairsBIT(): Int {
    var res = 0
    val copy = this.clone()
    val bit = IntArray(copy.size + 1)
    copy.sort()
    for (num in this) {
        res += bit.search(copy.index(2L * num + 1))
        bit.insert(copy.index(num.toLong()))
    }
    return res
}

private fun IntArray.search(num: Int): Int {
    var sum = 0
    var i = num
    while (i < size) {
        sum += this[i]
        i += i and -i
    }
    return sum
}

private fun IntArray.insert(num: Int) {
    var i = num
    while (i > 0) {
        this[i] += 1
        i -= i and -i
    }
}

private fun IntArray.index(value: Long): Int {
    var l = 0
    var r = size - 1
    var m: Int
    while (l <= r) {
        m = l + (r - l shr 1)
        if (this[m] >= value) {
            r = m - 1
        } else {
            l = m + 1
        }
    }
    return l + 1
}
