package com.kotlin.service.impl

import com.kotlin.model.Student
import com.kotlin.repository.StudentRepository
import com.kotlin.service.StudentService
import com.kotlin.service.exceptions.ResourceNotFoundException
import javax.inject.Singleton

@Singleton
class StudentServiceImpl(private val studentRepository: StudentRepository): StudentService {

    override fun findAllStudent(): List<Student> {
        return studentRepository.findAll()
    }

    override fun findStudentById(id: Long): Student {
        return studentRepository.findById(id).orElseThrow{ResourceNotFoundException(id.toString())}
        }
    }




