package com.KotlinMicronaut.service.exceptions

import java.lang.RuntimeException

class DatabaseException(message: String): RuntimeException(message) {
}