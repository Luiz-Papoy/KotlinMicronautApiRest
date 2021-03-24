package com.kotlin.model

import javax.persistence.*

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "Name")
    val name: String = "",

    @Column(name = "Email")
    val email: String = "",

    @Column(name = "Cpf")
    val cpf: String = "",

    @Column(name = "Ra")
    val ra: String = ""
)

