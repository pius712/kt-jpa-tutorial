package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long> {
}