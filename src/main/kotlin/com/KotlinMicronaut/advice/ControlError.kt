package com.KotlinMicronaut.advice

import com.fasterxml.jackson.annotation.JsonFormat
import java.io.Serializable
import java.time.Instant

data class ControlError(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone =  "GMT")
     var timestamp: Instant,

     var status: Int,
     var error: String,
     var message: String,
     var path: String?
): Serializable {}