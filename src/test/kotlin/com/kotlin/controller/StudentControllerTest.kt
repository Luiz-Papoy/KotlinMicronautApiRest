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
    fun `Should retun sucess created when create student`() {
        every { studentService.createStudent(any()) }.returns(student)
        val result = studentController.createStudent(student)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(HttpResponse.created(student).body()!!, result.body()!!)
        Assertions.assertEquals(HttpStatus.CREATED, result.status)
        Assertions.assertEquals(HttpStatus.CREATED.code, result.code())

    }

    @Test
    fun `Should retun sucess ok  when get all students`() {
        every { studentService.findAllStudent() }.returns(listOf(student))
        val result = studentController.findAllStudent()
        val listOfStudents = listOf(student)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(listOfStudents, result.body()!!)
        Assertions.assertEquals(HttpStatus.OK, result.status)
        Assertions.assertEquals(HttpStatus.OK.code, result.code())
    }


    @Test
    fun `Should retun sucess ok when get student by id`() {
        every { studentService.findStudentById(any()) }.returns(student)
        val result = studentController.findStudentById(student.id!!)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(HttpResponse.ok(student).body()!!, result.body()!!)
        Assertions.assertEquals(HttpStatus.OK, result.status)
        Assertions.assertEquals(HttpStatus.OK.code, result.code())
    }

    @Test
    fun `Should retun sucess no content when delete student by id`() {
        every { studentService.deleteStudentById(any()) }.returns(Unit)
        val result = studentController.deleteStudentById(student.id!!)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(HttpStatus.NO_CONTENT, result.status)
        Assertions.assertEquals(HttpStatus.NO_CONTENT.code, result.code())
    }

    @Test
    fun `Should retun sucess ok when put student by id`() {
        every { studentService.updateStudentById(any(), any()) }.returns(student)
        val newStudent = Student(1L, "newname", "email@email.com", "4141414141", "012391032921")
        val result = studentController.updateStudant(newStudent, student.id!!)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(HttpResponse.ok(newStudent).body()!!, newStudent)
        Assertions.assertEquals(HttpStatus.OK, result.status)
        Assertions.assertEquals(HttpStatus.OK.code, result.code())
        Assertions.assertEquals(HttpStatus.OK.code, 200)
    }

}