package io.spring.kotlinadvanced.chapter01_제네릭.lec05_제약과_함수

import io.spring.kotlinadvanced.chapter01_제네릭.lec01_03_제네릭과_타입_파라미터.Animal

fun main() {

    val cage = Cage(mutableListOf(Salmon(), Mackerel()))
    cage.printAll()
}

class Cage<T>(
    private val animals: MutableList<T> = mutableListOf()
) where T : Animal, T : Comparable<T>
{

    fun printAll() {
        this.animals.sorted()
            .map { it.name }
            .let { println(it) }
    }

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

}

abstract class Fish(
    name: String,
) : Animal(name), Comparable<Fish> {

    override fun compareTo(other: Fish): Int {
        return this.name.compareTo(other.name)
    }

}

class Salmon : Fish("연어")
class Mackerel : Fish("고등어")