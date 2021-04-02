package com.kotlin.service

import com.kotlin.model.Student
import com.kotlin.repository.StudentRepository
import com.kotlin.service.impl.StudentServiceImpl
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class StudentServiceTest {

    @InjectMockKs
    lateinit var studentService: StudentServiceImpl

    @MockK
    lateinit var studentRepository: StudentRepository

    lateinit var student: Student

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        student = Student(1L, "name", "email@email.com", "4141414141", "012391032921")
    }

    @Test
    fun `Should return sucess created when save student`() {
        every { studentRepository.save(any()) }.returns(student)
        val result = studentService.createStudent(student)
        Assertions.assertEquals(student,result)
    }

    @Test
    fun `Should return sucess ok when find student by id`() {
        every { studentRepository.findById(any()) }.returns(Optional.ofNullable(student))
        val result = studentService.findStudentById(student.id!!)
        Assertions.assertEquals(student,result)
    }

    @Test
    fun `Should return sucess ok when find all student`() {
        every { studentRepository.findAll() }.returns(listOf(student))
        val result = studentService.findAllStudent()
        val listOfStudents = listOf(student)
        Assertions.assertEquals(listOfStudents,result)
    }

    @Test
    fun `Should return deleted when delete student by id`() {
        every { studentRepository.existsById(any()) }.returns (true)
        every { studentRepository.deleteById(any()) }.returns (Unit)
        val result = studentService.deleteStudentById(student.id!!)
        Assertions.assertEquals(Unit,result)
    }

    @Test
    fun `Should return sucess ok when update student by id`() {
        every { studentRepository.existsById(any()) }.returns (true)
        val newStudent = Student(1L, "newname", "email@email.com", "4141414141", "012391032921")
        every { studentRepository.update(any()) }.returns (newStudent)
        val result = studentService.updateStudentById(newStudent,student.id!! )
        Assertions.assertEquals(newStudent,result)
    }
}


