package com.example.domain.user.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

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