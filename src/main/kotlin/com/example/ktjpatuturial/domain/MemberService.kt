package com.example.ktjpatuturial.domain

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository,
                    private val teamRepository: TeamRepository) {

    fun test(): List<MemberDto> {
        val member = memberRepository.findAllMember()
        return member.map {
            MemberDto(it)
        }
    }

    class MemberDto(
            val id: Long,
            val name: String,
            val team: List<TeamDto>
    ) {
        constructor(member: Member) : this(
                member.id!!,
                member.name,
                member.teams.map { TeamDto(it.id!!, it.teamName) })
    }

    class TeamDto(
            val id: Long,
            val teamName: String,
    ) {

    }

    @PostConstruct
    fun init() {
        val mem1 = Member("hi")
        memberRepository.save(mem1)

        val team1 = Team("team1", mem1)
        val team2 = Team("team2", mem1)
        teamRepository.saveAll(listOf(team1, team2))

//        val mem2 = Member("hi")
    }

}