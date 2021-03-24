package com.kotlin.controller.handler

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.Instant

import java.text.SimpleDateFormat

import java.text.DateFormat
import java.util.*


data class ControlError(
    val status: Int = 0,
    val error: String = "",
    val message: String = "",
    val path: String? = ""
)
