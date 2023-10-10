package com.example.ktjpatuturial.controller

import com.example.ktjpatuturial.domain.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member")
class MemberController(private val memberService: MemberService) {

    @GetMapping
    fun test(): List<MemberService.MemberDto> {
        return memberService.test();
    }
}