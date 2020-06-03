package dev.shtanko.algorithms.search

class LinearSearchTest : AbstractSearchTest<LinearSearch<Int>>(LinearSearch())

class BinarySearchTest : AbstractSearchTest<BinarySearch<Int>>(BinarySearch())

class BinaryRecursiveSearchTest : AbstractSearchTest<BinaryRecursiveSearch<Int>>(BinaryRecursiveSearch())