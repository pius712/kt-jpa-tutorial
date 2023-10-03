package com.example.ktjpatuturial.controller

import com.example.ktjpatuturial.domain.User
import com.example.ktjpatuturial.domain.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/user")
class UserController(private val userService: UserService) {

    @GetMapping("{id}")
    fun getUser(@PathVariable id: Long): User {
        return userService.getUser(id)
    }
}