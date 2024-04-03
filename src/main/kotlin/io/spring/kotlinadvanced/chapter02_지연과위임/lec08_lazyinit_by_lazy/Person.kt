package io.spring.kotlinadvanced.chapter02_지연과위임.lec08_lazyinit_by_lazy

class Person{

    val name: String by lazy {
        Thread.sleep(2000)
        "김민수"
    }

    val isKim: Boolean
        get() = this.name.startsWith("김")

    val maskingName: String
        get() = name[0] + (1 until name.length).joinToString("") { "*" }

}