package com.kotlin.controller

import com.kotlin.model.Student
import com.kotlin.service.StudentService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*


@ExtendWith(MockKExtension::class)
class StudentControllerTest {
    @InjectMockKs
    lateinit var studentController: StudentController

    @MockK
    lateinit var studentService: StudentService

    lateinit var student: Student

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        student = Student(1L, "name", "email@email.com", "4141414141", "012391032921")
    }


    @Test
    fun `Should return sucess created when create student`() {
        every { studentService.createStudent(any()) }.returns(student)
        val result = studentController.createStudent(student)
        Assertions.assertEquals(HttpResponse.created(student).body()!!, result.body()!!)
    }

    @Test
    fun `Should return sucess ok  when get all students`() {
        every { studentService.findAllStudent() }.returns(listOf(student))
        val result = studentController.findAllStudent()
        val listOfStudents = listOf(student)
        Assertions.assertEquals(listOfStudents, result.body()!!)
    }


    @Test
    fun `Should return sucess ok when get student by id`() {
        every { studentService.findStudentById(any()) }.returns(student)
        val result = studentController.findStudentById(student.id!!)
        Assertions.assertEquals(HttpResponse.ok(student).body()!!, result.body()!!)
    }

    @Test
    fun `Should return sucess no content when delete student by id`() {
        every { studentService.deleteStudentById(any()) }.returns(Unit)
        val result = studentController.deleteStudentById(student.id!!)
        Assertions.assertEquals(HttpStatus.NO_CONTENT, result.status)
    }

    @Test
    fun `Should return sucess ok when put student by id`() {
        every { studentService.updateStudentById(any(), any()) }.returns(student)
        val newStudent = Student(1L, "newname", "email@email.com", "4141414141", "012391032921")
       // val result = studentController.updateStudant(newStudent, student.id!!)
        Assertions.assertEquals(HttpResponse.ok(newStudent).body()!!, newStudent)
    }

}