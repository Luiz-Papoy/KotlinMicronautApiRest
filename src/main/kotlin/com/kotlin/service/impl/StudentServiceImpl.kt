package com.kotlin.service.impl

import com.kotlin.model.Student
import com.kotlin.repository.StudentRepository
import com.kotlin.service.StudentService
import com.kotlin.service.exceptions.DatabaseException
import com.kotlin.service.exceptions.ResourceNotFoundException
import java.lang.RuntimeException
import javax.inject.Singleton

@Singleton
class StudentServiceImpl(private val studentRepository: StudentRepository): StudentService {

    override fun createStudent(student: Student) {
        this.studentRepository.save(student)
    }

    override fun findAllStudent(): List<Student> {
        return studentRepository.findAll()
    }

    override fun findStudentById(id: Long): Student {
        return studentRepository.findById(id).orElseThrow{ResourceNotFoundException(id.toString())}
        }

    override fun deleteStudentById(id: Long) {
        try{
            studentRepository.deleteById(id)
        }catch(e: RuntimeException){
            throw ResourceNotFoundException(id.toString())
        }
    }
    }





