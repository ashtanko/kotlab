package dev.shtanko.oop

// Bad approach
class InheritanceInstrumentedHashSet<E> : HashSet<E>() {

    private var addCount = 0

    override fun add(element: E): Boolean {
        addCount++
        return super.add(element)
    }

    override fun addAll(elements: Collection<E>): Boolean {
        addCount += elements.size
        return super.addAll(elements)
    }

    fun getAddCount(): Int = addCount
}
