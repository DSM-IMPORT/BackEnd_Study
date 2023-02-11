package com.example.domain.user.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "user")
class UserJpaEntity(
    id: Long?,
    accountId: String,
    password: String,
    name: String,
    age: Int
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long? = id


    @Column(nullable = false, length = 20, unique = true)
    val accountId: String = accountId

    @Column(nullable = false, length = 60)
    val password: String = password

    @Column(nullable = false, length = 5)
    val name: String = name

    @Column(nullable = false, scale = 150)
    val age: Int = age
}