package com.KotlinMicronaut.controller
import com.KotlinMicronaut.model.Student
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class StudentControllerTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @Client("/") lateinit var client: RxHttpClient

    @Test
    fun findAllStudentTest() {
        val result = client.toBlocking().retrieve("http://localhost:8081/students", List::class.java)
        assertEquals(1,result.size)
    }


    @Test
    fun findByIdStudentTest() {
        val result = client.toBlocking().retrieve("http://localhost:8081/students/1", List::class.java)
        assertEquals(1,result.size)
    }



}
