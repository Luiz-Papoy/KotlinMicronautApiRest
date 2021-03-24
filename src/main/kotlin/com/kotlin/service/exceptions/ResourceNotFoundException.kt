package com.kotlin.service.exceptions

import java.lang.RuntimeException

class ResourceNotFoundException(message: String):
    RuntimeException("Resource Not found! This argument $message  not exist or was inserted incorrectly") {
}