package com.kotlin.model

import javax.persistence.*


@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @Column(name = "name")
    val name: String = "",

    @Column(name = "email")
    val email: String = "",

    @Column(name = "cpf")
    val cpf: String = "",

    @Column(name = "ra")
    val ra: String = ""
)

