package dev.shtanko.algorithms.sorts

data class TestObject(val id: Int, val name: String) : Comparable<TestObject> {

    override fun compareTo(other: TestObject): Int {

        val n = this.name.compareTo(other.name)
        return if (n == 0) this.id.compareTo(other.id) else n
    }
}