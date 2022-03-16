package com.shahry.shahry.base.remote

import com.shahry.shahry.R

class NetworkResponseHandler {
    companion object {
        //simple error codes handler
        fun <T> handleResponse(
            httpCode: Int?,
            response: T? = null,
        ): NetworkResponse<T> {
            return when (httpCode) {
                in 200..299 -> NetworkResponse.Success(response)
                in 401..403 -> NetworkResponse.Failure(
                    errorTypes = ErrorTypes.Error4xx,
                    errorMessageResId = R.string.auth_error
                )
                404 -> NetworkResponse.Failure(
                    errorTypes = ErrorTypes.Error4xx,
                    errorMessageResId = R.string.server_error
                )
                in 500..599 -> NetworkResponse.Failure(
                    errorTypes = ErrorTypes.Error5xx,
                    errorMessageResId = R.string.server_error
                )
                else -> NetworkResponse.Failure(
                    errorTypes = ErrorTypes.Unknown,
                    errorMessageResId = R.string.unExpected_error
                )
            }
        }
    }
}



