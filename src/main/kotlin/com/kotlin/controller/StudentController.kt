package com.kotlin.controller

import com.kotlin.model.Student
import com.kotlin.service.StudentService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("/students")
class StudentController(private val studentService: StudentService) {

    @Get
    fun findAll():HttpResponse<List<Student>>{
        val listOfStudents = studentService.findAllStudent()
        return when(listOfStudents){
            null -> HttpResponse.notFound()
            else -> {HttpResponse.ok(listOfStudents)}
        }
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long):HttpResponse<Student>{
        val obj = studentService.findStudentById(id)
        return when(obj){
            null -> HttpResponse.notFound()
            else -> {HttpResponse.ok(obj)}
        }
    }

}
