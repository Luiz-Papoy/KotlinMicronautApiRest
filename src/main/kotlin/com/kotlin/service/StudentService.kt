package com.kotlin.service

import com.kotlin.model.Student
import javax.inject.Singleton

@Singleton
interface StudentService {

    fun findAllStudent():List<Student>
    fun findStudentById(id: Long): Student?

}