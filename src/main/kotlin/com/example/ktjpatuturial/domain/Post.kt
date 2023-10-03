package com.example.ktjpatuturial.domain

import jakarta.persistence.*

@Entity
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(name = "ref_user_id")
        val userId: Long,
        @Column
        val contents: String) {

}