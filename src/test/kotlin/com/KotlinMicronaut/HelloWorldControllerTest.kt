package com.KotlinMicronaut
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @Client("/") lateinit var client: RxHttpClient

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun testHelloResponse(){
        val result = client.toBlocking().retrieve("http://localhost:8081/hello")
        assertEquals("HelloWorld",result)
    }

}
