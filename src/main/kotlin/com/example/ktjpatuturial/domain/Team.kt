package com.example.ktjpatuturial.domain

import jakarta.persistence.*


@Entity
class Team(
        @Column
        val teamName: String,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        val member: Member?
) : BaseEntity() {
}