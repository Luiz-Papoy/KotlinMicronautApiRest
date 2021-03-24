package com.kotlin.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name")
    var name: String = "",

    @Column(name = "email")
    var email: String = "",

    @Column(name = "cpf")
    var cpf: String = "",

    @Column(name = "ra")
    var ra: String = ""
)

