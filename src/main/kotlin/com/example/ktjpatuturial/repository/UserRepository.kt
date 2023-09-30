package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Long> {

    @Query("select distinct m , p from User m left join Post p on p.userId = m.id where m.id = :userId")
    fun getUser(userId: Long): List<Any?>
}