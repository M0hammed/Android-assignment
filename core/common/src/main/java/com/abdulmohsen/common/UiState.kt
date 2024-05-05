package com.me.common

sealed class UiState<T>(val data: T? = null) {
    class Success<T>(data: T?) : UiState<T>(data)
    class Error<T>(data: T? = null) : UiState<T>(data)
    class Loading<T>(data: T? = null) : UiState<T>(data)
}