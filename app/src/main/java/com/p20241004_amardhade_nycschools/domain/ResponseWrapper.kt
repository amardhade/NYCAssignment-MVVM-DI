package com.p20241004_amardhade_nycschools.domain

sealed class ResponseWrapper<out T> {

    data class Success<T>(val data: T) : ResponseWrapper<T>()
    data class Error(val message: String) : ResponseWrapper<Nothing>()
    data object Loading : ResponseWrapper<Nothing>()
    data object Idle : ResponseWrapper<Nothing>()


    fun isSuccess() = this is Success

    fun isError() = this is Error

    fun getSuccessData() = (this as Success).data

    fun getError() = (this as Error).message
}