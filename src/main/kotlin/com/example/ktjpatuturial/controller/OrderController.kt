package com.example.ktjpatuturial.controller

import com.example.ktjpatuturial.domain.Order
import com.example.ktjpatuturial.domain.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/order")
class OrderController(private val orderService: OrderService) {

    @GetMapping
    fun order(): List<Order> {
        return orderService.test()
    }
}