package com.example.domain.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class UserJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id:Long?,

    @Column(nullable = false)
    val accountId:String,

    @Column(nullable = false)
    val password:String,

    @Column(nullable = false)
    val name:String,

    @Column(nullable = false)
    val age:Int
)