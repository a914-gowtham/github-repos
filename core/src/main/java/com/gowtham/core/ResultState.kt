package com.gowtham.core

/**
 * A generic class for api call state ui handling.
 */
sealed class ResultState<out T> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val code: Int?, val message: String = "Something went wrong!") :
        ResultState<Nothing>()

    object Loading : ResultState<Nothing>()
}
