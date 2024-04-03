package io.spring.kotlinadvanced.chapter01_제네릭.lec06_타입소거_starProjection

fun main() {
    val strs: List<String> = listOf("A", "B", "C")
    val ints: List<Int> = listOf(1, 2 ,3)
}

class TypeErase {
}

fun checkList(data: Any) {
    if (data is MutableList<*>) {
        val element: Any? = data[0] // 꺼내는 것은 가능
//        data.add("1") // data의 타입을 특정할 수 없기 때문에 넣는 건 불가
//        data.add(1)   // data의 타입을 특정할 수 없기 때문에 넣는 건 불가
    }
}