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

    fun test(): List<Order> {
        val found = orderRepository.findAll()

//        val found = orderItemRepository.findByIdOrNull(1) ?: throw RuntimeException();
//        found.map { it.orderItems!!.map { it.item } }
//        return found.map {
//            println("this is ===============")
//            it.orderItems?.map {
//                println("that is ===============")
//                println(it)
//                it.item.name
//            }
//            it
//        };
        println(found);
        for (order in found) {
            for (items in order.orderItems!!) {
                println(items.item.name)
            }
        }
        return found

    }
//        return found;
//        println("after for statement")
//        return found.map { OrderDto(it) };
//    }

    @PostConstruct
    fun init() {
        val item1 = Item("item1")
        val item2 = Item("item2")
        itemRepository.saveAll(listOf(item1, item2))

        val order1 = Order("order1", null)
        val order2 = Order("order2", null)
        orderRepository.saveAll(listOf(order1, order2))


        val orderItem = OrderItem(order1, item1)
        val orderItem1 = OrderItem(order2, item2)

        orderItemRepository.saveAll(listOf(orderItem, orderItem1))
    }

}


data class OrderDto(
        val id: Long,
        val name: String,
        val orderItems: List<OrderItem>
) {

    constructor(order: Order) : this(
            order.id!!,
            order.name,
            order.orderItems!!
    ) {

    }
}

data class OrderItemDto(
        val id: Long,

        ) {

}