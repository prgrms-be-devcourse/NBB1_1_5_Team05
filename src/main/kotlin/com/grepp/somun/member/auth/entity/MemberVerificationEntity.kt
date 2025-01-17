package com.grepp.somun.member.auth.entity

import com.grepp.somun.member.entity.MemberEntity
import jakarta.persistence.*

@Entity
@Table(name = "member_verification")
data class MemberVerificationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "member_email", nullable = false)
    var memberEmail: String? = null,

    @Column(name = "verification_email", nullable = false, unique = true)
    var verificationEmail: String? = null,

    @OneToOne
    @JoinColumn(name = "member_email", referencedColumnName = "email", insertable = false, updatable = false)
    val member: MemberEntity? = null
)
