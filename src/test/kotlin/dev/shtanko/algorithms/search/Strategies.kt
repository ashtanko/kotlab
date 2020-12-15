package dev.shtanko.algorithms.search

internal class LinearSearchTest : AbstractSearchTest<LinearSearch<Int>>(LinearSearch())
internal class LinearSearchStringTest : AbstractStringSearchTest<LinearSearch<String>>(LinearSearch())

internal class BinarySearchTest : AbstractSearchTest<BinarySearch<Int>>(BinarySearch())
internal class BinarySearchStringTest : AbstractStringSearchTest<BinarySearch<String>>(BinarySearch())

internal class BinaryRecursiveSearchTest : AbstractSearchTest<BinaryRecursiveSearch<Int>>(BinaryRecursiveSearch())
internal class BinaryRecursiveStringSearchTest :
    AbstractStringSearchTest<BinaryRecursiveSearch<String>>(BinaryRecursiveSearch())
