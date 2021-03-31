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

@ExtendWith(MockKExtension::class)
class StudentControllerTest {
    @InjectMockKs
    lateinit var studentController: StudentController

    @MockK
    lateinit var studentService: StudentService

    lateinit var student: Student

    @BeforeEach
    fun setUp(){
        MockKAnnotations.init(this)
        student = Student(1L,"name","email@email.com","4141414141","012391032921")
    }


    @Test
    fun   `Should create student and return sucess`(){
        every { studentService.createStudent(any()) } return student
        studentController.createStudent(student)
        Assertions.assertEquals(student, )
    }

}