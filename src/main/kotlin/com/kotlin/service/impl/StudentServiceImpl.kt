package com.kotlin.service.impl

import com.kotlin.model.Student
import com.kotlin.repository.StudentRepository
import com.kotlin.service.StudentService
import com.kotlin.service.exceptions.ResourceNotFoundException
import java.lang.RuntimeException
import javax.inject.Singleton


@Singleton
class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {

    override fun createStudent(student: Student) {
        this.studentRepository.save(student)
    }

    override fun findAllStudent(): List<Student> {
        return studentRepository.findAll().toList()
    }

    override fun findStudentById(id: Long): Student {
        return studentRepository.findById(id).orElseThrow { ResourceNotFoundException(id.toString()) }
    }

    override fun deleteStudentById(id: Long) {
        try {
            studentRepository.deleteById(id)
        } catch (e: RuntimeException) {
            throw ResourceNotFoundException(id.toString())
        }
    }

    override fun updateStudentByid(name: String, email: String, cpf: String, ra: String, id: Long): Student {
        if (studentRepository.findById(id) == null) {
            throw ResourceNotFoundException(id.toString())
        }
        return studentRepository.updateStudentByid(name, email, cpf, ra, id)
    }

}



