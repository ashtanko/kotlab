package dev.shtanko.algorithms.extensions

fun <T> Array<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

fun IntArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

fun <T> Array<T>.reverse() {
    val n = this.size
    for (i in 0 until n / 2)
        this.swap(i, n - 1 - i)
}

fun <T> Array<T>.reverse2() {
    var i = 0
    var j = size - 1
    while (i < j) {
        swap(i, j)
        i++
        j--
    }
}

fun <T> Array<T>.flip(left: Int, right: Int) {
    var l = left
    var r = right
    while (l <= r) {
        swap(l++, r--)
    }
}

fun CharArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}
