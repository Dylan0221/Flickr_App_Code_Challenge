package com.example.flickr_code_challenge.utils

open class IOResult<T>(
    val type: ResultType,
    val body: T?
)

enum class ResultType{
    SUCCESS,
    FAILED,
    INPROGRESS
}