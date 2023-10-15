package com.example.ktjpatuturial.domain

import com.example.ktjpatuturial.repository.ItemRepository
import com.example.ktjpatuturial.repository.OrderItemRepository
import com.example.ktjpatuturial.repository.OrderRepository
import jakarta.annotation.PostConstruct
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
@Transactional
class OrderService(private val orderRepository: OrderRepository,
                   private val itemRepository: ItemRepository,
                   private val orderItemRepository: OrderItemRepository) {

    fun test(): List<OrderDto> {
        val found = orderRepository.findAll()
        return found.map {
            OrderDto(it)
        }

    }


    fun fetchJoinTest(): List<OrderDto> {
        val found = orderRepository.findOrderWithAll();
        return found.map {
            OrderDto(it)
        }
    }

    @PostConstruct
    fun init() {
        val item1 = Item("item1")
        val item2 = Item("item2")
        itemRepository.saveAll(listOf(item1, item2))

        val order1 = Order("order1")
        val order2 = Order("order2")
        orderRepository.saveAll(listOf(order1, order2))


        val orderItem = OrderItem(order1, item1)
        val orderItem1 = OrderItem(order1, item2)
        val orderItem2 = OrderItem(order2, item1)
        val orderItem3 = OrderItem(order2, item2)

        orderItemRepository.saveAll(listOf(orderItem, orderItem1, orderItem2, orderItem3))
    }


    class OrderDto(
            val id: Long,
            val name: String,
            val orderItems: List<OrderItemDto>
    ) {

        constructor(order: Order) : this(
                order.id!!,
                order.name,
                order.orderItems.map {
                    println("=======start=======")
                    val value = OrderItemDto(it)
                    println("=======end=======")
                    value
                }
        ) {

        }
    }

    class OrderItemDto(
            val id: Long,
            val itemName: String
    ) {

        constructor(orderItem: OrderItem) : this(orderItem.id!!, orderItem.item.name)
    }
}


