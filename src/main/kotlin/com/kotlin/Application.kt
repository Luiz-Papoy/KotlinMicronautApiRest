package com.kotlin

import com.kotlin.model.Student
import io.micronaut.runtime.Micronaut

fun main(args: Array<String>) {
    Micronaut.build()
        .args(*args)
        .packages("com.kotlin")
        .start()
}