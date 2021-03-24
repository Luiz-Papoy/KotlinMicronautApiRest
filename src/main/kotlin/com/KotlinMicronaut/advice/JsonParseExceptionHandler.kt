package com.KotlinMicronaut.advice.handler

import com.KotlinMicronaut.advice.ControlError
import com.fasterxml.jackson.core.JsonParseException
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler

import java.time.Instant
import javax.inject.Singleton


@Produces
@Singleton
@Requires(classes = [JsonParseException::class, ControlError::class])
class JsonParseExceptionHandler: ExceptionHandler<JsonParseException?, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>?, exception: JsonParseException?): HttpResponse<*> {
        val error : HttpStatus = HttpStatus.BAD_REQUEST
        val message = "Json Error!"
        val jsonParseError = ControlError(Instant.now(),400,error.toString(), message, request?.uri.toString() )
        return HttpResponse.badRequest(jsonParseError)
    }
}