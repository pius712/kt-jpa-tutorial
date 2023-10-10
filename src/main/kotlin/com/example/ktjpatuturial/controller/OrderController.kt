package com.example.ktjpatuturial.controller

import com.example.ktjpatuturial.domain.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/order")
class OrderController(private val orderService: OrderService) {

    @GetMapping
    fun order(): List<OrderService.OrderDto> {
        return orderService.test()
    }
    
    @GetMapping("/fetch-join")
    fun orderFetchJoin(): List<OrderService.OrderDto> {
        return orderService.fetchJoinTest();
    }
}