package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {


}