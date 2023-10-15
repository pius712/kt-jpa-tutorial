package com.example.ktjpatuturial.domain

import jakarta.annotation.PostConstruct
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class MemberService(private val memberRepository: MemberRepository,
                    private val teamRepository: TeamRepository) {

    fun test(): List<MemberDto> {
        val member = memberRepository.findAllMember()
        return member.map {
            MemberDto(it)
        }
    }

    fun test2(): List<MemberDto> {
        val member = memberRepository.findAll();
        return member.map {
            println("=========this ====")
            it.teams!!
            println("=========that =========")
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
                member.teams.map {
                    println("============")
                    TeamDto(it.id!!, it.teamName)
                })
    }

    class MemberDto2(
            val id: Long,
            val name: String,
    ) {
        constructor(member: Member) : this(
                member.id!!,
                member.name,
        )
    }

    class TeamDto(
            val id: Long,
            val teamName: String,
    ) {

    }

    @PostConstruct
    fun init() {
        val mem1 = Member("hi")
        val mem2 = Member("hi2")
        memberRepository.save(mem1)
        memberRepository.save(mem2)

        val team1 = Team("team1", mem1)
        val team2 = Team("team2", mem1)
        val team3 = Team("team1", mem2)
        val team4 = Team("team2", mem2)
        teamRepository.saveAll(listOf(team1, team2, team3,
                team4))

//        val mem2 = Member("hi")
    }

}