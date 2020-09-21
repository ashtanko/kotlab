package dev.shtanko.patterns.behavioral.iterator

interface CustomIterator<out T> {

    operator fun hasNext(): Boolean

    operator fun next(): T?
}
