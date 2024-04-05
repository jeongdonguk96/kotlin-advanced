package io.spring.kotlinadvanced.chapter03_함수형프로그래밍.lec01_고차함수와_함수리터럴

fun main() {
    // 람다식
    compute(1, 2) { a, b -> a + b }

    // 익명함수
    compute(1, 2, fun(a, b) = a + b)

    // 람다식 (return 사용 불가)
    iterate(listOf(1, 2, 3, 4, 5)) { num ->
        if (num != 3) {
            println(num)
        }
    }

    // 익명함수 (return 사용 가능)
    iterate(listOf(1, 2, 3, 4, 5), fun(num) {
        if (num == 3) {
            return
        }

        println(num)
    })
}

// a와 b는 숫자 파라미터 변수, op는 2개의 숫자를 받아 하나의 숫자로 반환하는 함수 파라미터
fun compute(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

fun iterate(numbers: List<Int>, execute: (Int) -> Unit) {
    for (number in numbers) {
        execute(number)
    }
}