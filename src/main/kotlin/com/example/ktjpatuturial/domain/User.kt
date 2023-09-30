package com.example.ktjpatuturial.domain

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id @GeneratedValue
        val id: Long? = null,

        @Column
        val name: String,
) {


}