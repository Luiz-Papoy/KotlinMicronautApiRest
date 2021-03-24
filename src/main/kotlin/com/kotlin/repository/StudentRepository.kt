package com.kotlin.repository

import com.kotlin.model.Student
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface StudentRepository : JpaRepository<Student, Long> {

    @Query("update Student s set s.name = ?1, s.email = ?2, " +
            "s.cpf = ?3, s.ra = ?4 where s.id = ?5")
    fun updateStudentByid(name: String, email: String, cpf: String, ra: String, id: Long): Student


}