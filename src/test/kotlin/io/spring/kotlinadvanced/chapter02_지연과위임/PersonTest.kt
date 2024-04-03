package io.spring.kotlinadvanced.chapter02_지연과위임

import io.spring.kotlinadvanced.chapter02_지연과위임.lec08_lazyinit_by_lazy.Person
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class PersonTest {

    private val person = Person()

    @Test
    fun 성이_김인지_확인한다() {
        // given
        val person = person.apply { name = "김민수" }

        // when & then
        assertThat(person.isKim).isTrue()
    }

    @Test
    fun 이름이_마스킹처리되는_것을_확인한다() {
        // given
        val person = person.apply { name = "정동욱" }

        // when & then
        assertThat(person.maskingName).isEqualTo("정**")
    }

}