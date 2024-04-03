package io.spring.kotlinadvanced.chapter02_지연과위임.lec10_by

import kotlin.properties.Delegates

fun main() {
    val person = Person()
    person.age = 20
    person.age = 30
    person.age = 30

    val person2 = Person2()
    person2.age = 20
    println("나이: ${person2.age}")
    person2.age = 0
    println("나이: ${person2.age}")
    person2.age = 1
    println("나이: ${person2.age}")

}

class Person {
    var age: Int by Delegates.observable(0) {
            _, oldValue, newValue ->
        if (oldValue != newValue) {
            println("초기 값: ${oldValue}, 새로운 값: ${newValue}")
        }
    }
}

class Person2 {
    var age: Int by Delegates.vetoable(0) {
            _, _, newValue ->
        newValue >= 1
    }
}

class Person3 {
    @Deprecated("age를 사용하세요", ReplaceWith("age"))
    var num: Int = 0

    var age:Int by this::num
}