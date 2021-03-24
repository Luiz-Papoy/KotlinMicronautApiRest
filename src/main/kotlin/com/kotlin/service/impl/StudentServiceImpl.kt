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

    override fun updateStudanteById(student: Student, id: Long) {
        try{
            val findedStudent = this.findStudentById(id)
            updateData(findedStudent,student)
        }catch(e: RuntimeException){
            throw ResourceNotFoundException(id.toString())
        }
    }




    fun updateData(oldStudentData: Student, newStudentData: Student ){
        oldStudentData.name = newStudentData.name
        oldStudentData.email = newStudentData.email
        oldStudentData.cpf = newStudentData.cpf
        oldStudentData.ra = newStudentData.ra
    }
}





