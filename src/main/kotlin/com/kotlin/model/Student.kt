package com.kotlin.model

import javax.persistence.*


@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = null,
    var name: String = "",
    var email: String = "",
    var cpf: String = "",
    var ra: String = ""
)

