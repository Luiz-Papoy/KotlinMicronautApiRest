package com.kotlin.service.exceptions

import java.lang.RuntimeException

class DatabaseException(message: String): RuntimeException(message) {
}