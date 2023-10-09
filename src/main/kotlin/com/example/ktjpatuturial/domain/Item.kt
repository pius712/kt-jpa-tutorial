package com.example.ktjpatuturial.domain

import jakarta.persistence.Entity

@Entity
class Item(
        var name: String
) : BaseEntity()
