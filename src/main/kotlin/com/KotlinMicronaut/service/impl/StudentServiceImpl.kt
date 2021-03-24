package com.KotlinMicronaut.service.impl

import com.KotlinMicronaut.model.Student
import com.KotlinMicronaut.repository.StudentRepository
import com.KotlinMicronaut.service.StudentService
import com.KotlinMicronaut.service.exceptions.ResourceNotFoundException
import javax.inject.Singleton

@Singleton
class StudentServiceImpl(private var studentRepository: StudentRepository): StudentService {

    override fun findAllStudent(): List<Student> {
        return studentRepository.findAll()
    }

    override fun findStudentById(id: Long): Student {
        return studentRepository.findById(id).orElseThrow{ResourceNotFoundException(id.toString())}
        }
    }




