package io.spring.kotlinadvanced.chapter03_함수형프로그래밍.lec01_고차함수와_함수리터럴

fun main() {
    println(calculate(2, 5, Operator.PLUS))
}

fun calculate(a: Int, b: Int, op: Operator) = op.calculateFun(a, b)

enum class Operator(
    private val op: Char,
    val calculateFun: (Int, Int) -> Int,
) {

    PLUS('+', { a, b -> a + b }),
    MINUS('-', { a, b -> a - b }),
    MULTIPLY('*', { a, b -> a * b }),
    DIVIDE('/', { a, b ->

        if (b == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다")
        } else {
            a / b
        }

    }),
}