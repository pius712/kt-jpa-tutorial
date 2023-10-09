package com.example.ktjpatuturial.repository

import com.example.ktjpatuturial.domain.Item
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<Item, Long> {
}