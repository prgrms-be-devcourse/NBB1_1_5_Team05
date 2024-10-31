package com.grepp.somun.member.entity

import com.grepp.somun.performance.entity.CategoryEntity
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@Table(name = "member_categories")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(
    AuditingEntityListener::class
)
class MemberCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_category_id")
    private var memberCategoryId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private val member: MemberEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private val category: CategoryEntity? = null

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private var createdAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private var updatedAt: LocalDateTime? = null
}