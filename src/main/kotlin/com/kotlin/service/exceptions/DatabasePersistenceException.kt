package com.kotlin.service.exceptions

import javax.persistence.PersistenceException

class DatabasePersistenceException(message: String) : PersistenceException(message) {
}