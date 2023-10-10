package com.example.ktjpatuturial.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "orders")
class Order(
        var name: String,
        @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
        var orderItems: MutableList<OrderItem> = mutableListOf()
) : BaseEntity() {
}