package io.spring.kotlinadvanced.chapter01_제네릭.lec04_선언지점변성_사용지점변성

import io.spring.kotlinadvanced.chapter01_제네릭.lec01_03_제네릭과_타입_파라미터.Animal
import io.spring.kotlinadvanced.chapter01_제네릭.lec01_03_제네릭과_타입_파라미터.Carp
import io.spring.kotlinadvanced.chapter01_제네릭.lec01_03_제네릭과_타입_파라미터.Fish
import io.spring.kotlinadvanced.chapter01_제네릭.lec01_03_제네릭과_타입_파라미터.GoldFish

fun main() {
    // out은 꺼내는 것만 가능, 담는 건 불가능
    val carpCage = Cage<Carp>()
    val animalCage: Cage<Animal> = carpCage
    println(animalCage.getFirst())
    println(animalCage.getAll())
    println(animalCage)

    // in은 담는 것만 가능, 꺼내는 건 불가능
    val fishCage = Cage2<Fish>()
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))
    println(fishCage)
}

// 선언 지점 변성: 클래스에 키워드 명시
class Cage<out T>(
    private val animals: MutableList<T> = mutableListOf()
) {

    fun getFirst(): T {
        return this.animals.first()
    }

    fun getAll(): List<T> {
        return this.animals
    }
}

// 선언 지점 변성: 클래스에 키워드 명시
class Cage2<in T>(
    private val animals: MutableList<T> = mutableListOf()
) {

    fun put(animal: T) {
        this.animals.add(animal)
    }
}