package com.example.ktjpatuturial.domain

import com.example.ktjpatuturial.repository.PostRepository
import com.example.ktjpatuturial.repository.UserRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.dao.IncorrectResultSizeDataAccessException

@SpringBootTest
class UserServiceTest(
        @Autowired private val userRepository: UserRepository,
        @Autowired private val postRepository: PostRepository
) {
    @BeforeEach
    fun init() {
        val user1 = User(name = "kim")
        val user2 = User(name = "lee")
        val user3 = User(name = "park")
        val user4 = User(name = "kim")
        userRepository.saveAll(listOf(user1, user2, user3, user4))

        postRepository.save(Post(userId = 1, contents = "1"))
        postRepository.save(Post(userId = 1, contents = "2"))
    }


    @Test
    fun queryAnnotation1() {
        val user = userRepository.getUser(1)
        println(user)
        Assertions.assertThat(user.name).isEqualTo("kim")
    }

    @Test
    @DisplayName("test 2")
    fun queryAnnotation2() {
        val user = userRepository.findUserBy("lee")
        println(user)
        Assertions.assertThat(user.name).isEqualTo("lee")
    }

    @Test
    @DisplayName("query method")
    fun queryMethodTest() {
        val user = userRepository.findUserBy("lee")
        println(user)
        Assertions.assertThat(user.name).isEqualTo("lee")
    }


    @Test
    @DisplayName("non nullable return 인데 없는 경우 에러")
    fun queryMethodTest2() {
        Assertions.assertThatThrownBy {
            userRepository.findByName("good")
        }.isInstanceOf(EmptyResultDataAccessException::class.java)
    }

    @Test
    @DisplayName("nullable return 인데 없는 경우 null")
    fun queryMethodTest3() {
        val found = userRepository.findUserByName("good")
        Assertions.assertThat(found).isNull()
    }

    @Test
    @DisplayName("여러 건인데, 단건으로 매핑하는경우 에러")
    fun queryMetoddTest4() {

        // NonUniqueResultException 에러를
        // spring 에서 변환해서 던지는듯?
        Assertions.assertThatThrownBy {
            userRepository.findAByName("kim")
        }.isInstanceOf(IncorrectResultSizeDataAccessException::class.java)
    }
}