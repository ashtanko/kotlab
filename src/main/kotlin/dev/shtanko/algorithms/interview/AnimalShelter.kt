package dev.shtanko.algorithms.interview

import java.util.LinkedList

sealed class Animal
data class Dog(val name: String) : Animal()
data class Cat(val name: String) : Animal()

internal class AnimalShelter {
    companion object {
        private var lastCount = 0
    }

    data class Timestamped<T>(val inner: T, val time: Int) {
        companion object {
            fun <T> make(inner: T): Timestamped<T> = Timestamped(inner, lastCount++)
        }
    }

    private val dogs = LinkedList<Timestamped<Dog>>()
    private val cats = LinkedList<Timestamped<Cat>>()

    fun enqueue(animal: Animal) {
        when (animal) {
            is Dog -> dogs.add(Timestamped.make(animal))
            is Cat -> cats.add(Timestamped.make(animal))
        }
    }

    fun dequeueDogs(): Dog {
        val dog = dogs.first.inner
        dogs.removeFirst()
        return dog
    }

    fun dequeueCat(): Cat {
        val cat = cats.first.inner
        cats.removeFirst()
        return cat
    }

    fun dequeueAny(): Animal {
        val oldestDog = dogs.first
        val oldestCat = cats.first

        return if (oldestDog.time < oldestCat.time) {
            dequeueDogs()
        } else {
            dequeueCat()
        }
    }
}
