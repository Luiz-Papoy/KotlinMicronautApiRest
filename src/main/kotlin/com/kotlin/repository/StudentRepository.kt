package com.kotlin.repository

import com.kotlin.model.Student
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface StudentRepository: JpaRepository<Student,Long> {
}