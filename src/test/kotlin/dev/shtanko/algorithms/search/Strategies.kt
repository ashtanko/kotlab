package dev.shtanko.algorithms.search

//region linear
class LinearSearchTest : AbstractSearchTest<LinearSearch<Int>>(LinearSearch())

class LinearSearchStringTest : AbstractStringSearchTest<LinearSearch<String>>(LinearSearch())
//endregion

//region binary
class BinarySearchTest : AbstractSearchTest<BinarySearch<Int>>(BinarySearch())

class BinarySearchStringTest : AbstractStringSearchTest<BinarySearch<String>>(BinarySearch())
//endregion

//region binary recursive
class BinaryRecursiveSearchTest : AbstractSearchTest<BinaryRecursiveSearch<Int>>(BinaryRecursiveSearch())

class BinaryRecursiveStringSearchTest : AbstractStringSearchTest<BinaryRecursiveSearch<String>>(BinaryRecursiveSearch())
//endregion