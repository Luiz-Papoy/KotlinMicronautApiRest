package com.KotlinMicronaut.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable
import javax.persistence.*


@Entity
data class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private var id: Long? = null,

    @Column(name = "Name")
    private var name: String = "",

    @Column(name = "Email")
    private var email: String = "",

    @Column(name = "Cpf")
    private var cpf: String = "",

    @Column(name = "Ra")
    private var ra: String = ""


): Serializable{

    fun getName() = this.name
    fun getEmail() = this.email
    fun getCpf() = this.cpf
    fun getRa() = this.ra

    fun setName(name: String){
        this.name = name
    }

    fun setEmail(email: String){
        this.email = email
    }

    fun setCpf(cpf: String){
        this.cpf = cpf
    }

    fun setRa(ra: String){
        this.ra = ra
    }

}
