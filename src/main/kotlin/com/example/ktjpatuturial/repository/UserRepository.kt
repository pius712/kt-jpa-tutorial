package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Long> {

//    @Query("select distinct m , p from User m left join Post p on p.userId = m.id where m.id = :userId")
//    fun getUser(userId: Long): User

    @Query("select u from User u where u.id =:userId ")
    fun getUser(userId: Long): User

    @Query("select u from User u where u.name =:name")
    fun findUserBy(name: String): User

    fun findByName(name: String): User

    fun findUserByName(name: String): User?

    fun findAByName(name: String): User
}