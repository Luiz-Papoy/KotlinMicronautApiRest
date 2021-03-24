package com.kotlin.controller

import com.kotlin.model.Student
import com.kotlin.service.StudentService
import io.micronaut.context.annotation.Parameter
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/students")
class StudentController(private val studentService: StudentService) {

    @Post
    fun createStudent(@Valid @Body student: Student): HttpResponse<Unit> {
        studentService.createStudent(student)
        return HttpResponse.created(Unit)
    }

    @Get
    fun findAllStudent(): HttpResponse<List<Student>> {
        val listOfStudents = studentService.findAllStudent()
        return HttpResponse.ok(listOfStudents)
    }

    @Get("/{id}")
    fun findStudentById(@PathVariable id: Long): HttpResponse<Student> {
        val obj = studentService.findStudentById(id)
        return when (obj) {
            null -> HttpResponse.notFound()
            else -> {
                HttpResponse.ok(obj)
            }
        }
    }
/*
@Get("/sort")
    fun finaAllSort(@Parameter() paramType: String,
                    @RequestParam(required = false, defaultValue = "") paramOrder: String,
                    @RequestParam(required = false, defaultValue = "") paramValue: String,
                    @RequestParam(required = false, defaultValue = "0") start: Int,
                    @RequestParam(required = false, defaultValue = "5") size: Int)
            : ResponseEntity<List<User>>{
        val listOfUsers = userService.findAllSort(paramType, paramOrder, paramValue, start, size)
        val status = if(listOfUsers != null) HttpStatus.OK else HttpStatus.NOT_FOUND
        return ResponseEntity(listOfUsers,status)
    }
 */


    /*

    @Get("{?max,offset}")
    public List<Person> findAll(@Nullable Integer max, @Nullable Integer offset) {
        return persons.stream()
                .skip(offset == null ? 0 : offset)
                .limit(max == null ? 10000 : max)
                .collect(Collectors.toList());
    }
     */

    @Delete("/id}")
    fun deleteStudentById(@PathVariable id: Long): HttpResponse<Unit> {
        if (studentService.findStudentById(id) != null) {
            studentService.deleteStudentById(id)
            return HttpResponse.noContent()
        }
        return HttpResponse.notFound()
    }

    @Put("/{id}")
    fun updateStudant(@Valid @Body student: Student, @PathVariable id: Long): HttpResponse<Unit> {
        if (studentService.findStudentById(id) != null) {
            studentService.deleteStudentById(id)
            return HttpResponse.ok()
        }
        return HttpResponse.notFound()
    }

}
