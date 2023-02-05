package com.example.domain.feed.entity

import com.example.domain.user.entity.UserJpaEntity
import javax.persistence.*

@Entity
class FeedJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: UserJpaEntity?
)