package com.kotlin.repository

import com.kotlin.model.Student

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.PageableRepository

@Repository
interface StudentRepository : PageableRepository<Student, Long> {}