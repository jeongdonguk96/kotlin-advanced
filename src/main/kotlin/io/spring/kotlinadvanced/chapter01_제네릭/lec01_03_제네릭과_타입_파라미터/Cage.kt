package io.spring.kotlinadvanced.chapter01_제네릭.lec01_03_제네릭과_타입_파라미터

fun main() {
    // case 1
    val cage = Cage()
    cage.put(Carp("잉어"))

    val carp1: Animal = cage.getFirst() // getFirst()는 Animal 타입을 반환함
    println(carp1)
    val carp2: Carp = cage.getFirst() as Carp // as를 이용해 타입 캐스팅
    println(carp2)


    // case 2
    // 제네릭 클래스를 인스턴스화 할 때 타입 파라미터를 지정하면
    // 제네릭 부분이 모두 지정한 타입으로 적용된다.
    val carpCage = Cage2<Carp>()
    carpCage.put(Carp("잉어"))

    val carp3: Carp = carpCage.getFirst() // carpCage 인스턴스 시 타입 파라미터를 Carp로 지정해주어 가능
    println(carp3)


    // case 3
    val goldFishCage = Cage2<GoldFish>()
    val fishCage  = Cage2<Fish>()

    goldFishCage.put(GoldFish("금붕어"))
    fishCage.moveFrom(goldFishCage) // 기본적으로 부모 타입으로 자동 형변환되지 않는다.
    fishCage.put(GoldFish("금붕어")) // 직접 넣는 건 가능하다.

    // Fish 타입의 인스턴스만 생성 가능하다.
    val first: Fish = fishCage.getFirst()     // O
//    val second: GoldFish = fishCage.getFirst() // X


    // case 4
    val fishCage2 = Cage2<Fish>()
    val goldFishCage2 = Cage2<GoldFish>()
    goldFishCage2.put(GoldFish("금붕어"))

    goldFishCage2.moveTo(fishCage2) // O
}

class Cage(
    private val animals: MutableList<Animal> = mutableListOf()
) {

    fun getFirst(): Animal {
        return animals.first()
    }

    fun put(animal: Animal) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage) {
        this.animals.addAll((cage.animals))
    }

}

// 제네릭 클래스
class Cage2<T>(
    private val animals: MutableList<T> = mutableListOf()
) {
    
    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    // 사용 지점 변성: 함수에 키워드 명시
    fun moveFrom(cage2: Cage2<out T>) {
        this.animals.addAll(cage2.animals)
    }

    // 사용 지점 변성: 함수에 키워드 명시
    fun moveTo(cage2: Cage2<in T>) {
        cage2.animals.addAll(this.animals)
    }

}