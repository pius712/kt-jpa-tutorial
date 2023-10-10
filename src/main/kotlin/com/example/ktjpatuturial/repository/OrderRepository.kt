package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface OrderRepository : JpaRepository<Order, Long> {


    // fetch join -> 쿼리하나로 데이터 가져올 수 있음.
    @Query("select o from Order o join fetch o.orderItems oi join fetch oi.item i")
    fun findOrderWithAll(): List<Order>
}