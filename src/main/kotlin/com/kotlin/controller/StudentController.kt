package com.kotlin.controller

import com.kotlin.model.Student
import com.kotlin.service.StudentService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/students")
class StudentController(private val studentService: StudentService) {

    @Post("/create")
    fun createStudent(@Valid @Body student: Student): HttpResponse<Unit>{
        val student = studentService.createStudent(student)
        return when (student) {
            null -> HttpResponse.badRequest()
            else -> {
                HttpResponse.created(student)
            }
        }
    }

    @Get
    fun findAllStudent():HttpResponse<List<Student>>{
        val listOfStudents = studentService.findAllStudent()
        return when(listOfStudents){
            null -> HttpResponse.notFound()
            else -> {HttpResponse.ok(listOfStudents)}
        }
    }

    @Get("/{id}")
    fun findStudentById(@PathVariable id: Long):HttpResponse<Student>{
        val obj = studentService.findStudentById(id)
        return when(obj){
            null -> HttpResponse.notFound()
            else -> {HttpResponse.ok(obj)}
        }
    }

    @Delete("/{id}")
    fun deleteStudentById(@PathVariable id: Long): HttpResponse<Unit>{
        studentService.deleteStudentById(id)
        return HttpResponse.noContent()
    }
/*
    @Put("/{id}")
    fun updateStudant(@Body student: Student,@PathVariable id: Long ): HttpResponse<Unit>{

    }
*/
}
