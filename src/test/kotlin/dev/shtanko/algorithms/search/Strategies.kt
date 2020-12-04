package dev.shtanko.algorithms.search

class LinearSearchTest : AbstractSearchTest<LinearSearch<Int>>(LinearSearch())
class LinearSearchStringTest : AbstractStringSearchTest<LinearSearch<String>>(LinearSearch())

class BinarySearchTest : AbstractSearchTest<BinarySearch<Int>>(BinarySearch())
class BinarySearchStringTest : AbstractStringSearchTest<BinarySearch<String>>(BinarySearch())

class BinaryRecursiveSearchTest : AbstractSearchTest<BinaryRecursiveSearch<Int>>(BinaryRecursiveSearch())
class BinaryRecursiveStringSearchTest : AbstractStringSearchTest<BinaryRecursiveSearch<String>>(BinaryRecursiveSearch())
