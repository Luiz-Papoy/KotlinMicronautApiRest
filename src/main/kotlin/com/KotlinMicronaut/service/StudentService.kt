package com.KotlinMicronaut.service

import com.KotlinMicronaut.model.Student
import javax.inject.Singleton

@Singleton
interface StudentService {

    fun findAllStudent():List<Student>
    fun findStudentById(id: Long): Student?

}