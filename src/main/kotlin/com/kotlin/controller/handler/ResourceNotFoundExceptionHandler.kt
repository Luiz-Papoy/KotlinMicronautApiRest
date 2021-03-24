package com.kotlin.controller.handler.handler

import com.kotlin.controller.handler.ControlError
import com.kotlin.service.exceptions.ResourceNotFoundException
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
@Requires(classes = [ResourceNotFoundException::class, ControlError::class])
class ResourceNotFoundExceptionHandler : ExceptionHandler<ResourceNotFoundException?, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>?, exception: ResourceNotFoundException?): HttpResponse<*> {
        val error: HttpStatus = HttpStatus.NOT_FOUND
        val message = "Resource Not Found!"
        val resourceNotFoundError = ControlError(404, error.toString(), message, request?.uri.toString())
        return HttpResponse.notFound(resourceNotFoundError)
    }
}