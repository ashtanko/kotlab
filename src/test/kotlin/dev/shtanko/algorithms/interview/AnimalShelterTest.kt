package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AnimalShelterTest {

    @Test
    fun `Animal shelter test`() {
        val animalShelter = AnimalShelter()
        val dog1 = Dog("sean's dog")
        val cat1 = Cat("jim's cat 1")
        val cat2 = Cat("jim's cat 2")
        val dog2 = Dog("my friend's dog")

        animalShelter.enqueue(dog1)
        animalShelter.enqueue(cat1)
        animalShelter.enqueue(cat2)
        animalShelter.enqueue(dog2)

        assertTrue(animalShelter.dequeueAny() == dog1)
        assertTrue(animalShelter.dequeueAny() == cat1)

        assertTrue(animalShelter.dequeueCat() == cat2)
        assertTrue(animalShelter.dequeueDogs() == dog2)
    }
}
