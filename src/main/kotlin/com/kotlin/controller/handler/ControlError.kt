package com.kotlin.controller.handler

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

data class ControlError(
     val timestamp: Instant,

     val status: Int,
     val error: String,
     val message: String,
     val path: String?
)