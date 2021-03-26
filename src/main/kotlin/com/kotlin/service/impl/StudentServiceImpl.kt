package com.kotlin.service.impl


import com.kotlin.model.Student
import com.kotlin.repository.StudentRepository
import com.kotlin.service.StudentService
import com.kotlin.service.exceptions.ResourceNotFoundException
import io.micronaut.data.annotation.Id
import io.micronaut.data.model.Pageable
import java.lang.RuntimeException
import java.util.*
import javax.inject.Singleton



@Singleton
class StudentServiceImpl(private val studentRepository: StudentRepository) : StudentService {

    override fun createStudent(student: Student) {
        this.studentRepository.save(student)
    }

    override fun findAllStudent(): List<Student> {
        return studentRepository.findAll(Pageable.from(0, 5)).toList()
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

    override fun updateStudentById(student: Student, @Id id: Long): Student {
        try {
            val entity = studentRepository.findById(id)
            updateData(entity, student)
            return this.studentRepository.save(entity)
        } catch (e: ResourceNotFoundException) {
            throw ResourceNotFoundException(id.toString())

        }

    }

    fun updateData(baseStudent: Optional<Student>, incomingStudent: Student) {
        baseStudent.name = incomingStudent.name
        baseStudent.email = incomingStudent.email
        baseStudent.cpf = incomingStudent.cpf
        baseStudent.ra = incomingStudent.ra
    }
}


