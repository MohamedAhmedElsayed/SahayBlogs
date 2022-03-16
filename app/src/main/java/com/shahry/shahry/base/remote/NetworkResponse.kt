package com.shahry.shahry.base.remote

import androidx.annotation.IdRes

/**
 * Common class used by API responses.
 * @param <T> the type of the response object
</T> */
sealed class NetworkResponse<T> {
    data class Success<T>(
        val data: T?,
    ) : NetworkResponse<T>()

    data class Failure<T>(
        val errorTypes: ErrorTypes,
         val errorMessageResId: Int
    ) : NetworkResponse<T>()
}