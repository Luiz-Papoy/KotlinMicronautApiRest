package com.kotlin.model

import io.micronaut.core.annotation.Introspected
import javax.persistence.*


@Entity
@Introspected
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long? = 0,
    var name: String = "",
    var email: String = "",
    var cpf: String = "",
    @Column(unique = true)
    var ra: String = ""
)

