package com.example.ktjpatuturial.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Post(
        @Id @GeneratedValue
        val id: Long? = null,

        @Column(name = "ref_user_id")
        val userId: Long,
        @Column
        val contents: String) {

}