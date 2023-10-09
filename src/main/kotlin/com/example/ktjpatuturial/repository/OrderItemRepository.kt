package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Long> {
}