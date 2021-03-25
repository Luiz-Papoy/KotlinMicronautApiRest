package com.kotlin.model

import javax.persistence.*


@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    var name: String = "",
    var email: String = "",
    var cpf: String = "",
    var ra: String = ""
)

