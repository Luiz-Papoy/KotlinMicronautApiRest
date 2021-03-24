package com.kotlin.controller.handler.handler

import com.kotlin.controller.handler.ControlError
import com.kotlin.service.exceptions.DatabaseException
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler

import java.time.Instant
import java.util.*
import javax.inject.Singleton


@Produces
@Singleton
@Requires(classes = [DatabaseException::class, ControlError::class])
class DataBaseExceptionHandler : ExceptionHandler<DatabaseException?, HttpResponse<*>> {


    override fun handle(request: HttpRequest<*>?, exception: DatabaseException?): HttpResponse<*> {
        val error: HttpStatus = HttpStatus.BAD_REQUEST
        val message = "Database Integrity error!"
        val dataBaseIntegrityError = ControlError(400, error.toString(), message, request?.uri.toString())
        return HttpResponse.badRequest(dataBaseIntegrityError)
    }
}