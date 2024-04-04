package io.spring.kotlinadvanced.chapter02_지연과위임.lec11_위임클래스

interface Fruit {
    val name: String
    val color: String
    fun bite()
}

class Apple : Fruit {
    override val name: String
        get() = "사과"
    override val color: String
        get() = "빨간색"

    override fun bite() {
        println("사과를 한 입 먹는다")
    }
}

class GreenApple(
    private val apple : Apple
) : Fruit by apple {
    override val color: String
        get() = "초록색"
}