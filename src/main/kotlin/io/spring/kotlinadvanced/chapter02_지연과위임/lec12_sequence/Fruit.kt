package io.spring.kotlinadvanced.chapter02_지연과위임.lec12_sequence

import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    val fruits = mutableListOf<Fruit>()

    fun init() {
        (1..2_000).forEach { _ -> fruits.add(Fruit.random())}
        println("테스트 데이터 생성 완료")
    }

    fun kotlinSequence() {
        val measureTime = measureTime {
            val avg = fruits.asSequence()
                .filter { it.name == "사과" }
                .map { it.price }
                .take(10_000)
                .average()
        }

        println("시퀀스 방식 소요 시간 : $measureTime")
    }

    fun kotlinIterable() {
        val measureTime = measureTime {
            val avg = fruits
                .filter { it.name == "사과" }
                .map { it.price }
                .take(10_000)
                .average()
        }

        println("Iterable 방식 소요 시간 : $measureTime")
    }


    init()
    println("데이터 수: ${fruits.size}, 1번 데이터: ${fruits[0]}")

    kotlinSequence()
    kotlinIterable()
}

data class Fruit(
    val name: String,
    val price: Long,
) {

    companion object {
        private val NAME_CANDIDATES = listOf("사과", "바나나", "수박", "체리", "오렌지")
        fun random(): Fruit {
            val randNum1 = Random.nextInt(0, 5)
            val randNum2 = Random.nextLong(1000, 20001)

            return Fruit(
                name = NAME_CANDIDATES[randNum1],
                price = randNum2
            )
        }
    }

}
