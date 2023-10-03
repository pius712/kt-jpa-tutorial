package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {


    fun findByUserId(userId: Long, pageable: Pageable): Page<Post>
    fun findPostByUserId(userId: Long, pageable: Pageable): List<Post>
}