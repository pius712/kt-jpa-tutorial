package com.example.ktjpatuturial.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class OrderItem(
        @ManyToOne(fetch = FetchType.LAZY)
        @JsonIgnore
        var order: Order,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "orders_id")
        @JsonIgnore
        var item: Item,
) : BaseEntity()
