package com.kotlin.service

import com.kotlin.model.Student
import javax.inject.Singleton

@Singleton
interface StudentService {

    fun createStudent(student: Student)
    fun findAllStudent(): List<Student>
    fun findStudentById(id: Long): Student?
    fun deleteStudentById(id: Long)
    fun updateStudanteById(student: Student, id: Long)

}