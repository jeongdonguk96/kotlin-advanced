package io.spring.kotlinadvanced

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinAdvancedApplication

fun main(args: Array<String>) {
    runApplication<KotlinAdvancedApplication>(*args)
}
