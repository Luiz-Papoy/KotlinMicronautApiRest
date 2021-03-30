package com.kotlin.controller.handler.handler

import com.kotlin.controller.handler.ControlError

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler

import javax.inject.Singleton
import javax.persistence.PersistenceException


@Produces
@Singleton
@Requires(classes = [PersistenceException::class, ControlError::class])
class PersistenceExceptionHandler : ExceptionHandler<PersistenceException?, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>?, exception: PersistenceException?): HttpResponse<*> {
        val error: HttpStatus = HttpStatus.BAD_REQUEST
        val message = "Database Persistence Error! Try some valid values!"
        val persistenceError = ControlError(400, error.toString(), message, request?.uri.toString())
        return HttpResponse.badRequest(persistenceError)
    }
}