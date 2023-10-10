package com.example.ktjpatuturial.domain

import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
class Member(
        val name: String,
        @OneToMany(mappedBy = "member")
        val teams: List<Team> = mutableListOf()
) : BaseEntity() {

}