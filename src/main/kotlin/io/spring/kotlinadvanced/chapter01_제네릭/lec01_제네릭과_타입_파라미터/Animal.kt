package io.spring.kotlinadvanced.chapter01_제네릭.lec01_제네릭과_타입_파라미터

abstract class Animal(
    val name: String,
)

abstract class Fish(
    name: String,
) : Animal(name)

class GoldFish(
    name: String,
) : Fish(name)

class Carp(
    name: String,
) : Fish(name)