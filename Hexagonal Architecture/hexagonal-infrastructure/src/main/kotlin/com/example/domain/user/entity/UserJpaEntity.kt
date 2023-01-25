package com.example.domain.user.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull

@Entity
class UserJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id:Long?,

    @NotNull
    val accountId:String,

    @NotNull
    val password:String,

    @NotNull
    val name:String,

    @NotNull
    val age:Int
)