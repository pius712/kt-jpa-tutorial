package com.example.ktjpatuturial.domain

import com.example.ktjpatuturial.repository.PostRepository
import com.example.ktjpatuturial.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository,
                  private val postRepository: PostRepository) {


    fun getUser(userId: Long): User {
        return userRepository.getUser(userId)
    }

    fun getUserByName(name: String): User {
        return userRepository.findUserBy(name)
    }

    fun init() {
        val user1 = User(name = "kim")
        val user2 = User(name = "lee")
        val user3 = User(name = "park")
        userRepository.saveAll(listOf(user1, user2, user3))

        postRepository.save(Post(userId = 1, contents = "1"))
        postRepository.save(Post(userId = 1, contents = "2"))

    }
}