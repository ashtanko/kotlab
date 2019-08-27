@file:JvmName("Demo")

import java.util.Hashtable

private class Human(val age: Int, val name: String)

private data class Animal(val age: Int)

fun main() {

    val max = Human(15, "Max")
    val sameMax = Human(15, "Max")

    println(max.hashCode() == sameMax.hashCode()) //false

    val cat = Animal(2)
    val sameCat = Animal(2)

    println(cat.hashCode() == sameCat.hashCode()) //true

    val humans = Hashtable<Human, Human>()
    humans[max] = max
    humans[sameMax] = sameMax

    println(humans)

    val animals = Hashtable<Animal, Animal>()
    animals[cat] = cat
    animals[sameCat] = sameCat

    println(animals)

}