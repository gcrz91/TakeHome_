package com.cruz.republicservices.helper

sealed interface AsyncResult<out T> {
    object Loading : AsyncResult<Nothing>
    data class Success<T>(val data: T) : AsyncResult<T>
    data class Failure(val error: String) : AsyncResult<Nothing>
}

fun <T> success(data: T) = AsyncResult.Success(data)
fun failure(message: String) = AsyncResult.Failure(message)
