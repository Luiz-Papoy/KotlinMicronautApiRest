package com.kotlin.service.impl


import com.kotlin.controller.handler.handler.PersistenceExceptionHandler
import com.kotlin.model.Student
import com.kotlin.repository.StudentRepository
import com.kotlin.service.StudentService
import com.kotlin.service.exceptions.DatabaseException
import com.kotlin.service.exceptions.DatabasePersistenceException
import com.kotlin.service.exceptions.ResourceNotFoundException
import io.micronaut.data.annotation.Id
import io.micronaut.data.model.Pageable
import java.lang.RuntimeException
import java.util.*
import javax.inject.Singleton
import javax.persistence.PersistenceException


@Singleton
class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {

    override fun createStudent(student: Student): Student {
        try {
            return this.studentRepository.save(student)
        } catch (e: PersistenceException) {
            throw DatabasePersistenceException("")
        }

    }

    override fun findAllStudent(): List<Student> {
        //return studentRepository.findAll(Pageable.from(0, 5)).toList()
        return studentRepository.findAll().toList()

    }

    override fun findStudentById(id: Long): Student {
        return studentRepository.findById(id).orElseThrow { ResourceNotFoundException(id.toString()) }
    }

    override fun deleteStudentById(id: Long) {
        if (!studentRepository.existsById(id)) {
            throw ResourceNotFoundException(id.toString())
        }
        studentRepository.deleteById(id)
    }

    override fun updateStudentById(student: Student, @Id id: Long): Student {
        val entity: Student
        if (student.id != null && studentRepository.existsById(id)) {
            entity = studentRepository.update(student)
            return entity
        }
        throw ResourceNotFoundException(id.toString())
    }

}

