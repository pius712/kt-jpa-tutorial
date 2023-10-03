package com.example.ktjpatuturial.domain

import com.example.ktjpatuturial.repository.PostRepository
import jakarta.transaction.Transactional
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull

@SpringBootTest
class PagingTest(
        @Autowired private val postRepository: PostRepository
) {

    @BeforeEach
    @Transactional
    fun init() {
        val post1 = Post(userId = 1, contents = "this is 1")
        val post2 = Post(userId = 1, contents = "this is 2")
        val post3 = Post(userId = 1, contents = "this is 3")
        val post4 = Post(userId = 1, contents = "this is 4")
        postRepository.saveAll(listOf(post1, post2, post3, post4))
    }

    @Test
    @Transactional
    @DisplayName("Page 타입으로 처리하는 경우에는 count 쿼리가 나간다.")
    fun test() {
        val found = postRepository.findByUserId(1, PageRequest.of(0, 2))
        Assertions.assertThat(found.totalPages).isEqualTo(2)
        Assertions.assertThat(found.totalElements).isEqualTo(4)
        Assertions.assertThat(found.content[0].userId).isEqualTo(1)
        Assertions.assertThat(found.content[1].contents).isEqualTo("this is 2")
    }

    @Test
    @Transactional
    @DisplayName("list type으로 받는 경우에는 count 쿼리 안나간다.")
    fun test2() {
        val found = postRepository.findPostByUserId(1, PageRequest.of(0, 2))
        Assertions.assertThat(found[0].userId).isEqualTo(1)
        Assertions.assertThat(found[1].userId).isEqualTo(3)
    }

    @Test
    fun test3() {
        val found = postRepository.findByIdOrNull(2)
        Assertions.assertThat(found).isNull()
    }


}