package com.abdulmohsen.network.http

import retrofit2.Response

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> = try {
    val response = call.invoke()
    if (response.isSuccessful && response.body() != null) {
        Result.success(response.body()!!)
    } else {
        Result.failure(NetworkError())
    }
} catch (e: Exception) {
    Result.failure(NetworkError())
}

class NetworkError : Throwable()