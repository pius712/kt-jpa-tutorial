package com.example.ktjpatuturial.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MemberRepository : JpaRepository<Member, Long> {


    // hibernate 6 부터는 distinct 없어도, 애플리케이션에서 중복 제거를 해준다.
    @Query("select m from Member m join fetch m.teams")
    fun findAllMember(): List<Member>;
}